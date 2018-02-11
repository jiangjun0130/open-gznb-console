package com.gznb.open.dao.mybatis.custom;

import com.gznb.open.domain.BusinessPlatform;
import com.gznb.open.domain.custom.BusinessPlatformCustom;
import com.gznb.open.domain.custom.BusinessPlatformMerchantCustom;
import com.gznb.open.domain.vo.BusinessPlatformVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by kl09 on 2017/6/30.
 */
public interface BusinessPlatformMapperCustom {

    /**
     * 新建应用，返回主键
     *
     * @param businessPlatform
     * @return
     */
    int insert(BusinessPlatform businessPlatform);

    /**
     * 查询“我的应用”列表
     *
     * @param businessPlatformVo
     * @return
     */
    List<BusinessPlatformCustom> getPagedData(BusinessPlatformVo businessPlatformVo);

    /**
     * 统计总数
     *
     * @param vo
     * @return
     */
    Integer getRecordCount(BusinessPlatformVo vo);

    BusinessPlatformCustom queryWithChannel(@Param("busniessId") int busniessId,@Param("envFlag") Integer envFlag);

    /**
     * 查询商户集合以及对应的公钥、秘钥信息
     *
     * @param sysPlateFormId 系统平台ID
     * @param busPlatformId  业务系统平台ID
     * @return 商户集合
     */
    List<BusinessPlatformMerchantCustom> queryMechantWithBusniessEntry(@Param("sysPlateFormId") Integer
                                                                               sysPlateFormId, @Param
                                                                               ("busPlatformId") Integer busPlatformId,@Param("envFlag") Integer envFlag);
}
