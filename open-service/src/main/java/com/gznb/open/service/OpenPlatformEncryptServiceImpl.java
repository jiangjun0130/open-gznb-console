package com.gznb.open.service;

import com.gznb.open.common.config.SystemConfig;
import com.gznb.open.common.constants.Constants;
import com.gznb.open.common.constants.ExceptionEnum;
import com.gznb.open.common.exception.SystemErrorException;
import com.gznb.open.common.utils.RSAUtils;
import com.gznb.open.dao.mybatis.OpenPlatformEncryptMapper;
import com.gznb.open.domain.OpenPlatformEncrypt;
import com.gznb.open.domain.OpenPlatformEncryptExample;
import com.gznb.open.domain.OpenPlatformEncryptWithBLOBs;
import com.gznb.open.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("openPlatformEncryptService")
public class OpenPlatformEncryptServiceImpl extends AbstractService<OpenPlatformEncryptServiceImpl> implements
        IOpenPlatformEncryptService {

    /**
     * 秘钥记录状态——正常（1）
     */
    private static final String STATUS_NORMAL = "1";
    /**
     * 秘钥记录状态——禁用（2）
     */
    private static final String STATUS_DISABLE = "2";
    /**
     * 秘钥记录状态——删除（2）
     */
    private static final String STATUS_DELETE = "3";

    /**
     * 环境标识——prd
     */
    private static final String ENVFLAG_PRD = "4";
    /**
     * 环境标识——pre
     */
    private static final String ENVFLAG_PRE = "3";
    /**
     * 环境标识——test
     */
    private static final String ENVFLAG_TEST = "2";
    /**
     * 环境标识——dev
     */
    private static final String ENVFLAG_DEV = "1";

    /**
     * 密钥对类型——请求秘钥对
     */
    private static final String ENCRYPT_TYPE_REQUEST = "1";
    /**
     * 密钥对类型——响应密钥对
     */
    private static final String ENCRYPT_TYPE_RESPONSE = "2";

    @Autowired
    private OpenPlatformEncryptMapper openPlatformEncryptMapper;

    @Autowired
    private SystemConfig systemConfig;

    @Autowired
    private IUploadService iUploadService;

    @Override
    public Map<String, List<OpenPlatformEncrypt>> query() {
        OpenPlatformEncryptExample openPlatformEncryptExample = new OpenPlatformEncryptExample();
        openPlatformEncryptExample.or().andEncryptStatusEqualTo(STATUS_NORMAL).andEnvFlagEqualTo(systemConfig
                .getEnvFlag());
        List<OpenPlatformEncrypt> openPlatformEncrypts = openPlatformEncryptMapper.selectByExample(openPlatformEncryptExample);
        Map<String, List<OpenPlatformEncrypt>> collect = new HashMap<>();
        if (openPlatformEncrypts != null && openPlatformEncrypts.size() > 0) {
            for (OpenPlatformEncrypt openPlatformEncrypt : openPlatformEncrypts) {
                openPlatformEncrypt.setPrivateKeyUri(systemConfig.getImageUrl() + openPlatformEncrypt.getPrivateKeyUri());
                openPlatformEncrypt.setPublicKeyUri(systemConfig.getImageUrl() + openPlatformEncrypt.getPublicKeyUri());
            }
            collect = openPlatformEncrypts.stream()
                    .collect(Collectors.groupingBy(OpenPlatformEncrypt::getEnvFlag));
        }
        return collect;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void generateKey() throws Exception {
        try {
            // 所有操作针对，当前系统环境（dev、test、pre、prd）
            // step1、将该环境之前所有记录状态置为删除
            delete();
            // step2、再次生成各个环境秘钥
            // step3、将生成的秘钥文件上传的文件服务器
            // step4、将生成的秘钥信息保存到数据库
            generateRSAKey(ENCRYPT_TYPE_REQUEST);
            generateRSAKey(ENCRYPT_TYPE_RESPONSE);
        } catch (Exception e) {
            throw e;
        }

    }

    private void delete() throws Exception {
        try {
            OpenPlatformEncryptExample ope = new OpenPlatformEncryptExample();
            ope.or().andEncryptStatusEqualTo(STATUS_NORMAL).andEnvFlagEqualTo(systemConfig.getEnvFlag());
            OpenPlatformEncryptWithBLOBs record = new OpenPlatformEncryptWithBLOBs();
            record.setEncryptStatus(STATUS_DELETE);
            openPlatformEncryptMapper.updateByExampleSelective(record, ope);
        } catch (Exception e) {
            String extraMsg = "删除秘钥记录异常";
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    /*private void handleEncrypt(String type) throws Exception {
        try {
            generateRSAKey(type, ENVFLAG_PRD);
            generateRSAKey(type, ENVFLAG_PRE);
            generateRSAKey(type, ENVFLAG_TEST);
            generateRSAKey(type, ENVFLAG_DEV);
        } catch (Exception e) {
            throw e;
        }
    }*/

    /**
     * step1、生成秘钥信息<br/>
     * step2、上传秘钥文件到文件服务器<br/>
     * step3、保存秘钥信息到数据库<br/>
     *
     * @param type 请求秘钥对（1），响应秘钥对（2）
     * @throws Exception
     */
    private void generateRSAKey(String type) throws Exception {
        try {
            String envFlag = systemConfig.getEnvFlag();
            Map<String, String> keyMap = RSAUtils.genKeyPair(Constants.RSA_KEY_LENGTH);
            String privateKey = keyMap.get(RSAUtils.PRIVATE_KEY);
            String publicKey = keyMap.get(RSAUtils.PUBLIC_KEY);

            OpenPlatformEncryptWithBLOBs openPlatformEncrypt = new OpenPlatformEncryptWithBLOBs();
            openPlatformEncrypt.setEncryptType(type);
            openPlatformEncrypt.setPublicKeyUri(iUploadService.uploadPic(publicKey.getBytes(),
                    RSAUtils.PUBLIC_KEY, (long) publicKey.length()));
            /*openPlatformEncrypt.setPublicKeyContent(publicKey);*/
            openPlatformEncrypt.setPublicKeyContent(null);
            openPlatformEncrypt.setPrivateKeyUri(iUploadService.uploadPic(privateKey.getBytes(),
                    RSAUtils.PRIVATE_KEY, (long) privateKey.length()));
    /*        openPlatformEncrypt.setPrivateKeyContent(privateKey);*/
            openPlatformEncrypt.setPrivateKeyContent(null);
            openPlatformEncrypt.setEncryptStatus(STATUS_NORMAL);
            openPlatformEncrypt.setEnvFlag(envFlag);
            // save
            openPlatformEncryptMapper.insertSelective(openPlatformEncrypt);
        } catch (Exception e) {
            String extraMsg = "生成秘钥信息异常！";
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }
}
