package com.gznb.open.dao.mybatis.custom;

import com.gznb.open.domain.BusinessPlateformEncryptWithBLOBs;
import com.gznb.open.domain.custom.BusinessPlatformEncryptCustom;
import com.gznb.open.domain.vo.api.BusPlatformEncryptVo;

import java.util.List;

public interface BusinessPlateformEncryptMapperCustom {

    /**
     * 获取业务系统公钥信息
     * @param vo
     * @return
     */
    BusinessPlatformEncryptCustom getBusPlatformPublicEncrypt(BusPlatformEncryptVo vo);

    /**
     * 批量插入
     * @param recordList
     * @return
     * @throws Exception
     */
    int insertBatch(List<BusinessPlateformEncryptWithBLOBs> recordList);
}

