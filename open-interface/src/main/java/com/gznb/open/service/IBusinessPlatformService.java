package com.gznb.open.service;

import com.gznb.open.domain.BusinessPlatform;
import com.gznb.open.domain.custom.BusinessPlatformCustom;
import com.gznb.open.domain.manual.DataCenter;
import com.gznb.open.domain.vo.BusinessPlatformVo;
import com.gznb.open.domain.vo.base.PageBean;

/**
 * 业务系统接口
 * Created by kl09 on 2017/6/28.
 */
public interface IBusinessPlatformService {

    /**
     * 新建项目
     *
     * @param businessPlatform
     */
    Integer insert(BusinessPlatform businessPlatform, BusinessPlatformVo vo) throws Exception;

    /**
     * 修改
     *
     * @param businessPlatform
     * @throws Exception
     */
    void update(BusinessPlatform businessPlatform) throws Exception;

    /**
     * 查询我的应用列表
     *
     * @param businessPlatformVo 查询参数、分页
     * @return PageBean
     * @throws Exception
     */
    PageBean getPagedData(BusinessPlatformVo businessPlatformVo) throws Exception;

    /**
     * 查询我的应用列表，包括该应用的申请记录
     * @param businessPlatformVo
     * @return
     * @throws Exception
     */
    PageBean getPageDataWithApply(BusinessPlatformVo businessPlatformVo) throws Exception;

    /**
     * 查询业务系统信息以及接入功能和账号
     * @param businessId
     * @return
     */
    BusinessPlatformCustom queryWithChannel(Integer businessId);
}
