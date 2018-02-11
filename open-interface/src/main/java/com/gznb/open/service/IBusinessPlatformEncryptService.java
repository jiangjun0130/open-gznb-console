package com.gznb.open.service;

import com.gznb.open.domain.BusinessPlateformEncrypt;
import com.gznb.open.domain.custom.BusinessPlatformEncryptCustom;
import com.gznb.open.domain.vo.api.BusPlatformEncryptVo;

/**
 * 业务系统密钥对服务接口
 *
 * @author jiangjun
 * @create 2017/11/7
 */
public interface IBusinessPlatformEncryptService {

    /**
     * 获取业务系统公钥信息
     * @param vo
     * @return
     */
    BusinessPlatformEncryptCustom getBusPlatformPublicEncrypt(BusPlatformEncryptVo vo) throws Exception;

    void delete(BusinessPlateformEncrypt recoed, BusinessPlateformEncrypt conditin) throws Exception;
}
