package com.gznb.open.service;

import com.gznb.open.domain.custom.SystemEncryptCustom;
import com.gznb.open.domain.vo.api.SysPlatformEncryptVo;

/**
 * 开发系统密钥对服务接口
 *
 * @author jiangjun
 * @create 2017/11/9
 */
public interface ISystemPlatformEncryptService {

    /**
     * 获取开放系统公钥信息
     * @param vo
     * @return
     * @throws Exception
     */
    SystemEncryptCustom getSysPlatformPrivateEncrypt(SysPlatformEncryptVo vo) throws Exception;
}
