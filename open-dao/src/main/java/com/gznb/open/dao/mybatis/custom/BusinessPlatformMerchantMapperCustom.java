package com.gznb.open.dao.mybatis.custom;

import com.gznb.open.domain.BusinessPlatformMerchant;
import com.gznb.open.domain.custom.BusinessPlatformMerchantCustom;
import com.gznb.open.domain.vo.BusinessMerchantVo;
import java.util.List;

/**
 * Created by sx07 on 2017/7/17.
 */
public interface BusinessPlatformMerchantMapperCustom {

    /**
     * 新建应用，返回主键
     *
     * @param businessPlatformMerchant
     * @return
     */
    int insert(BusinessPlatformMerchant businessPlatformMerchant);

    /**
     * 查询商户分页信息
     * @param vo
     * @return
     */
    List<BusinessPlatformMerchantCustom> getPagedData(BusinessMerchantVo vo);

    /**
     * 查询商户记录数
     * @param vo
     * @return
     */
    Integer getRecordCount(BusinessMerchantVo vo);
}
