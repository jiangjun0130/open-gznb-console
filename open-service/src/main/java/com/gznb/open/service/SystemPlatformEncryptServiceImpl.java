package com.gznb.open.service;

import com.gznb.open.common.config.SystemConfig;
import com.gznb.open.common.constants.ExceptionEnum;
import com.gznb.open.common.exception.SystemErrorException;
import com.gznb.open.dao.mybatis.custom.SystemEncryptMapperCustom;
import com.gznb.open.domain.custom.BusinessPlatformEncryptCustom;
import com.gznb.open.domain.custom.SystemEncryptCustom;
import com.gznb.open.domain.vo.api.SysPlatformEncryptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 开放系统密钥对服务接口
 *
 * @author jiangjun
 * @create 2017/11/9
 */
@Service("systemPlatformEncryptService")
public class SystemPlatformEncryptServiceImpl implements ISystemPlatformEncryptService{

    @Autowired
    private SystemEncryptMapperCustom mapperCustom;

    @Autowired
    private SystemConfig systemConfig;

    @Override
    public SystemEncryptCustom getSysPlatformPrivateEncrypt(SysPlatformEncryptVo vo) throws Exception {
        try {
            SystemEncryptCustom privateEncrypt = mapperCustom.getSysPlatformPrivateEncrypt(vo);
            if(privateEncrypt != null){
                privateEncrypt.setPrivateKeyUri(systemConfig.getImageUrl() + privateEncrypt.getPrivateKeyUri());
            }
            return privateEncrypt;
        } catch (Exception e) {
            String extraMsg = "查询开放系统密钥信息异常！查询参数：" + vo.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }
}
