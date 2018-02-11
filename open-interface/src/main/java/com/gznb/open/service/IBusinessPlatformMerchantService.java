package com.gznb.open.service;

import com.gznb.open.domain.BusinessPlatformMerchant;
import com.gznb.open.domain.vo.BusinessMerchantVo;
import com.gznb.open.domain.vo.base.PageBean;

/**
 * 商户管理——interface
 * Created by kl09 on 2017/7/20.
 */
public interface IBusinessPlatformMerchantService {

    /**
     * 修改商户信息
     *
     * @param businessPlatformMerchant
     */
    void update(BusinessPlatformMerchant businessPlatformMerchant) throws Exception;

    /**
     * 添加商户<br/>
     * 1、添加商户<br/>
     * 2、生成业务系统秘钥信息
     *
     * @param bean
     */
    void save(BusinessPlatformMerchant bean) throws Exception;

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    BusinessPlatformMerchant queryById(Integer id);

    /**
     *
     * @param merchantId
     * @throws Exception
     */
    void generateKey(BusinessPlatformMerchant merchantId) throws Exception;

    /**
     * 查询商户分页信息
     * @param vo
     * @return
     * @throws Exception
     */
    PageBean getPagedData(BusinessMerchantVo vo) throws Exception;

    /**
     * 禁用或重新启用商户
     * @param vo
     * @throws Exception
     */
    void disableOrEnable(BusinessMerchantVo vo) throws Exception;

    /**
     * 删除商户
     * @param vo
     * @throws Exception
     */
    void delete(BusinessMerchantVo vo) throws Exception;
}
