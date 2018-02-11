package com.gznb.open.dao.mybatis.custom;

import com.gznb.open.domain.BusinessPlatformChannelWithBLOBs;
import com.gznb.open.domain.custom.BusinessPlatformChannelCustom;
import com.gznb.open.domain.custom.BusinessPlatformMerchantCustom;
import com.gznb.open.domain.vo.BusinessChannelVo;
import com.gznb.open.domain.vo.BusinessPlatformChannelVo;

import java.util.List;

public interface BusinessPlatformChannelCustomMapper {

    /**
     * 查询渠道，分页
     *
     * @param vo 查询参数
     * @return
     */
    List<BusinessPlatformChannelWithBLOBs> queryWithPage(BusinessPlatformChannelVo vo);

    /**
     * 查询渠道,总数
     *
     * @param vo 查询参数
     * @return
     */
    Integer queryWithPageCount(BusinessPlatformChannelVo vo);

    /**
     * 查询渠道分页信息
     * @param vo
     * @return
     */
    List<BusinessPlatformChannelCustom> getPagedData(BusinessChannelVo vo);

    /**
     * 查询分页记录数
     * @param vo
     * @return
     */
    Integer getRecordCount(BusinessChannelVo vo);
}
