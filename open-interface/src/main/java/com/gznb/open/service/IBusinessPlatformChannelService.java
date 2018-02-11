package com.gznb.open.service;

import com.gznb.open.domain.BusinessPlatformChannel;
import com.gznb.open.domain.BusinessPlatformChannelWithBLOBs;
import com.gznb.open.domain.custom.BusinessPlatformChannelCustom;
import com.gznb.open.domain.custom.BusinessPlatformMerchantCustom;
import com.gznb.open.domain.vo.BusinessChannelVo;
import com.gznb.open.domain.vo.BusinessPlatformChannelVo;
import com.gznb.open.domain.vo.base.PageBean;

import java.util.List;

/**
 * 业务系统——渠道管理interface
 * Created by kl09 on 2017/7/11.
 */
public interface IBusinessPlatformChannelService {

    /**
     * 添加渠道
     *
     * @param businessPlatform
     */
    void save(BusinessPlatformChannelWithBLOBs businessPlatform) throws Exception;

    /**
     * 删除渠道
     *
     * @param channelId 渠道ID主键
     */
    void delete(Integer channelId) throws Exception;

    /**
     * 修改渠道信息
     *
     * @param businessPlatformChannel
     */
    void update(BusinessPlatformChannel businessPlatformChannel) throws Exception;

    /**
     * 查询渠道
     *
     * @param businessPlatformChannelWithBLOBs
     * @return
     */
    List<BusinessPlatformChannelWithBLOBs> query(BusinessPlatformChannelWithBLOBs businessPlatformChannelWithBLOBs)
            throws Exception;

    /**
     * 根据Id查询渠道信息
     *
     * @param id
     * @return
     */
    BusinessPlatformChannelCustom queryById(Integer id);

    /**
     * 查询渠道集合，分页
     *
     * @param vo 查询条件
     * @return 带分页信息
     */
    BusinessPlatformMerchantCustom queryWithChannel(BusinessPlatformChannelVo vo);

    /**
     * 查询分页
     * @param vo
     * @return
     * @throws Exception
     */
    PageBean getPagedData(BusinessChannelVo vo) throws Exception;
}
