package com.gznb.open.service;

import com.gznb.open.domain.BusSystemApplyRecord;
import com.gznb.open.domain.SystemPlatform;
import com.gznb.open.domain.vo.BusSystemApplyRecordVo;
import com.gznb.open.domain.vo.base.PageBean;

import java.util.List;

/**
 * 业务系统申请记录service
 * Created by kl09 on 2017/6/28.
 */
public interface IBusSystemApplyRecordService {

    /**
     * 业务申请记录查询
     *
     * @param applyRecordVo BusSystemApplyRecordVo 查询条件及参数
     * @return
     */
    PageBean getPagedData(BusSystemApplyRecordVo applyRecordVo) throws Exception;

    /**
     * 申请记录插入
     *
     * @param busSystemApplyRecord
     * @throws Exception
     */
    void save(BusSystemApplyRecord busSystemApplyRecord) throws Exception;

    /**
     * 查询业务系统还可以申请的系统列表
     * @param buinessSystemId 业务系统ID
     * @return
     * @throws Exception
     */
    List<SystemPlatform> queryMayApply(Integer buinessSystemId) throws Exception;

    void auditApply(BusSystemApplyRecord busSystemApplyRecord) throws Exception;

}
