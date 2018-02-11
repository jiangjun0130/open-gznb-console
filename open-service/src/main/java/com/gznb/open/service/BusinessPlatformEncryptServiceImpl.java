package com.gznb.open.service;

import com.gznb.open.common.config.SystemConfig;
import com.gznb.open.common.constants.ExceptionEnum;
import com.gznb.open.common.exception.SystemErrorException;
import com.gznb.open.dao.mybatis.BusinessPlateformEncryptMapper;
import com.gznb.open.dao.mybatis.custom.BusinessPlateformEncryptMapperCustom;
import com.gznb.open.domain.BusinessPlateformEncrypt;
import com.gznb.open.domain.BusinessPlateformEncryptExample;
import com.gznb.open.domain.custom.BusinessPlatformEncryptCustom;
import com.gznb.open.domain.vo.api.BusPlatformEncryptVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务系统密钥对服务
 *
 * @author jiangjun
 * @create 2017/11/7
 */
@Service("businessPlatformEncryptService")
public class BusinessPlatformEncryptServiceImpl implements IBusinessPlatformEncryptService {

    @Autowired
    private BusinessPlateformEncryptMapperCustom mapperCustom;

    @Autowired
    private BusinessPlateformEncryptMapper businessPlateformEncryptMapper;

    @Autowired
    private SystemConfig systemConfig;

    @Override
    public BusinessPlatformEncryptCustom getBusPlatformPublicEncrypt(BusPlatformEncryptVo vo) throws Exception {
        try {
            BusinessPlatformEncryptCustom publicEncrypt = mapperCustom.getBusPlatformPublicEncrypt(vo);
            if (publicEncrypt != null) {
                publicEncrypt.setPublicKeyUri(systemConfig.getImageUrl() + publicEncrypt.getPublicKeyUri());
            }
            return publicEncrypt;
        } catch (Exception e) {
            String extraMsg = "查询业务系统公钥信息异常！查询参数：" + vo.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Override
    public void delete(BusinessPlateformEncrypt recoed, BusinessPlateformEncrypt conditin) throws Exception {
        BusinessPlateformEncryptExample businessPlateformEncryptExample = new BusinessPlateformEncryptExample();
        BusinessPlateformEncryptExample.Criteria or = businessPlateformEncryptExample.or();
        try {
            if (conditin.getId() != null && conditin.getId() != 0) {
                or.andIdEqualTo(conditin.getId());
            }
            //商户
            if (conditin.getBusMerchantId() != null && conditin.getBusMerchantId() != 0) {
                or.andBusMerchantIdEqualTo(conditin.getBusMerchantId());
            }
            if (StringUtils.isNotEmpty(conditin.getEncryptStatus())) {
                or.andEncryptStatusEqualTo(conditin.getEncryptStatus());
            }
            if (StringUtils.isNotEmpty(conditin.getEnvFlag())) {
                or.andEnvFlagEqualTo(conditin.getEnvFlag());
            }
            businessPlateformEncryptMapper.updateByExample(recoed, businessPlateformEncryptExample);
        } catch (Exception e) {
            String extraMsg = "删除业务系统秘钥异常，参数：recoed" + recoed.toString() + "；  条件conditin：" + conditin.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }
}
