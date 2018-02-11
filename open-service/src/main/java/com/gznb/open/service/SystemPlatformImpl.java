package com.gznb.open.service;

import com.gznb.open.common.config.SystemConfig;
import com.gznb.open.common.constants.Constants;
import com.gznb.open.common.constants.ExceptionEnum;
import com.gznb.open.common.exception.SystemErrorException;
import com.gznb.open.common.utils.RSAUtils;
import com.gznb.open.dao.mybatis.SystemEncryptMapper;
import com.gznb.open.dao.mybatis.SystemPlatformMapper;
import com.gznb.open.dao.mybatis.custom.SystemEncryptMapperCustom;
import com.gznb.open.dao.mybatis.custom.SystemPlateformMapperCustom;
import com.gznb.open.domain.SystemEncrypt;
import com.gznb.open.domain.SystemEncryptExample;
import com.gznb.open.domain.SystemEncryptWithBLOBs;
import com.gznb.open.domain.SystemPlatform;
import com.gznb.open.domain.custom.SystemPlatformCustom;
import com.gznb.open.domain.custom.SystemPlatformDicCatalogCustom;
import com.gznb.open.domain.manual.EnvironmentEnum;
import com.gznb.open.domain.vo.SystemModuleVo;
import com.gznb.open.domain.vo.SystemPlatformVo;
import com.gznb.open.domain.vo.base.PageBean;
import com.gznb.open.service.base.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 系统平台服务接口实现类
 * <p>
 * Created by jj02 on 2017/6/15.
 */
@Service("platformService")
public class SystemPlatformImpl extends AbstractService<SystemPlatformImpl> implements ISystemPlatformService {

    @Autowired
    private SystemPlatformMapper mapper;

    @Autowired
    private SystemPlateformMapperCustom mapperCustom;

    @Autowired
    private IUploadService iUploadService;

    @Autowired
    private SystemConfig systemConfig;

    @Autowired
    private SystemEncryptMapper systemEncryptMapper;

    @Autowired
    private SystemEncryptMapperCustom systemEncryptMapperCustom;

    @Override
    @Transactional
    public int update(SystemPlatform platform) throws Exception {
        int rows = 0;
        try {
            if (platform.getId() == null) {
                // insert
                rows = this.doInsert(platform);
            } else {
                // update
                rows = this.doUpdate(platform);
            }
            if (rows < 1) {
                logger.warn("更新系统平台记录失败！rows: {} ^_^ record: {}", rows, platform.toString());
            }
//            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(), ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
//                    "测试异常回滚");
        } catch (Exception e) {
            throw e;
        }
        return rows;
    }

    /**
     * 执行添加操作
     *
     * @param platform
     * @return 添加行数
     */
    private Integer doInsert(SystemPlatform platform) throws Exception {
        try {
            Integer row = mapperCustom.insertSelectiveCustom(platform);
            this.generateRSAKey(platform.getEncryptType(), platform.getId());
            return row;
        } catch (Exception e) {
            String extraMsg = "添加统平台记录异常！新增记录：" + platform.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    /**
     * 执行修改操作，修改时判断是否为RSA加密，RSA则判断是否已经进行过密钥生成
     *
     * @param platform
     * @return 操作行数
     * @throws Exception 数据插入/修改异常
     */
    private Integer doUpdate(SystemPlatform platform) throws Exception {
        Integer rows;
        try {
            rows = mapper.updateByPrimaryKeySelective(platform);
            // 类型为RSA则判断是否已经生成过密钥，已生成则不再进行密钥生成操作
            if (!Constants.ENCRYPT_TYPE_RSA.equals(platform.getEncryptType())) {
                return rows;
            }
            SystemEncryptExample see = new SystemEncryptExample();
            see.or().andPlatformIdEqualTo(platform.getId());
            List<SystemEncryptWithBLOBs> systemEncryptWithBLOBs = systemEncryptMapper.selectByExampleWithBLOBs(see);
            if (systemEncryptWithBLOBs.size() == 0) {
                // 执行生成RSA密钥
                this.generateRSAKey(platform.getEncryptType(), platform.getId());
            }else {
                // 旧数据，删除后重新生成各个环境密钥
                if(StringUtils.isBlank(systemEncryptWithBLOBs.get(0).getEncryptStatus())){
                    // 删除旧数据
                    SystemEncryptWithBLOBs updateEncrypt = new SystemEncryptWithBLOBs();
                    updateEncrypt.setPlatformId(platform.getId());
                    updateEncrypt.setEncryptStatus(Constants.ENCRYPT_STATUS_DELETED);
                    updateEncrypt.setNote("旧数据删除！");
                    SystemEncryptExample updateExample = new SystemEncryptExample();
                    updateExample.or().andPlatformIdEqualTo(platform.getId());
                    systemEncryptMapper.updateByExampleSelective(updateEncrypt,updateExample);
                    this.generateRSAKey(platform.getEncryptType(), platform.getId());
                }
            }
            return rows;
        } catch (Exception e) {
            String extraMsg = "修改系统平台记录异常！参数为：" + platform.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }

    }

    /**
     * 生成RSA秘钥对，上传至服务器
     *
     * @param encryptType 加密类型
     * @param platfromId  系统平台ID
     * @throws Exception RSA加密异常
     */
    private void generateRSAKey(String encryptType, Integer platfromId) throws Exception {
        if (StringUtils.isBlank(encryptType) || !Constants.ENCRYPT_TYPE_RSA.equals(encryptType)) {
            return;
        }
        List<SystemEncryptWithBLOBs> encryptWithBLOBsList = new ArrayList<>();
        for (EnvironmentEnum e : EnvironmentEnum.values()) {
            Map<String, String> keyMap = RSAUtils.genKeyPair(Constants.RSA_KEY_LENGTH);
            String privateKey = keyMap.get(RSAUtils.PRIVATE_KEY);
            String publicKey = keyMap.get(RSAUtils.PUBLIC_KEY);
            SystemEncryptWithBLOBs encrypt = new SystemEncryptWithBLOBs();
            encrypt.setEncryptStatus(Constants.ENCRYPT_STATUS_NORMAL);
            encrypt.setPlatformId(platfromId);
            encrypt.setPublicKeyContent(publicKey);
            /*encrypt.setPrivateKeyContent(privateKey);*/
            encrypt.setPrivateKeyContent(null);
            encrypt.setPrivateKeyUri(iUploadService.uploadPic(privateKey.getBytes(),
                    RSAUtils.PRIVATE_KEY, (long) privateKey.length()));
            /*encrypt.setPublicKeyContent(publicKey);*/
            encrypt.setPublicKeyContent(null);
            encrypt.setPublicKeyUri(iUploadService.uploadPic(publicKey.getBytes(),
                    RSAUtils.PUBLIC_KEY, (long) publicKey.length()));
            encrypt.setEnvFlag(e.getEnvCode());
            encryptWithBLOBsList.add(encrypt);
        }
        //保存秘钥
        try {
          /*  systemEncryptMapper.insertSelective(encrypt);*/
            systemEncryptMapperCustom.insertBatch(encryptWithBLOBsList);
        } catch (Exception e) {
            String extraMsg = "添加RSA密钥失败！参数信息：" + encryptWithBLOBsList.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Override
    public PageBean getPagedData(SystemPlatformVo vo) throws Exception {
        // 查询分页数据
        calculateStartIndex(vo);
        try {
            List<SystemPlatformCustom> recordList = mapperCustom.getPagedData(vo);
            for (SystemPlatformCustom imgurlList : recordList) {
                String image = imgurlList.getPlatformImage();
                String imageUrl= systemConfig.getImageUrl() + image;
                imgurlList.setPlatformImage(imageUrl);
            }
            // 查询分页总数
            Integer recordCount = mapperCustom.getRecordCount(vo);
            return new PageBean(vo.getPageBean().getCurrentPage(), vo.getPageBean().getPageSize(), recordCount, recordList);
        } catch (Exception e) {
            String extraMsg = "查询系统平台列表信息异常！查询参数：" + vo.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Transactional
    @Override
    public int delete(Integer id) throws Exception {
        if(id == null){
            return 0;
        }
        int rows = 0;
        SystemPlatform record = new SystemPlatform();
        record.setId(id);
        record.setUpdateTime(new Date());
        record.setPlatformStatus(Constants.SYSTEM_DATA_STATUS_DELETE);
        try {
            rows = mapper.updateByPrimaryKeySelective(record);
        }catch (Exception e){
            String extraMsg = "删除系统平台记录异常！删除参数：" + record.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
        return rows;
    }

    @Override
    public SystemPlatform getDataById(Integer id) throws Exception {
        if(id == null){
            return null;
        }
        try {
            return mapper.selectByPrimaryKey(id);
        }catch (Exception e){
            String extraMsg = "查询系统平台指定信息异常！id：" + id;
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Override
    public List<SystemPlatformDicCatalogCustom> getDatadictionaryById(SystemModuleVo vo) throws Exception {
        calculateStartIndex(vo);
        try {
            List<SystemPlatformDicCatalogCustom> recordList = mapperCustom.getDatadictionaryById(vo);
            // 查询分页总数
        /*    Integer recordCount = mapperCustom.getDicCount(vo);
            return new PageBean(vo.getPageBean().getCurrentPage(), vo.getPageBean().getPageSize(), recordCount, recordList);*/
        return recordList;
        } catch (Exception e) {
            String extraMsg = "查询系统平台模块记录异常！查询参数：" + vo.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }
}
