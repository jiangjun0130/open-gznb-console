package com.gznb.open.service;

import com.gznb.open.domain.BusSystemAccess;
import com.gznb.open.domain.vo.BusSystemAccessVo;
import com.gznb.open.domain.vo.base.PageBean;

import java.util.List;

/**
 * 业务系统接入
 * Created by kl09 on 2017/6/28.
 */
public interface IBusSystemAccessService {
    /**
     * 查询接入信息
     *
     * @param platformId    系统平台标识
     * @param busPlatformId 业务系统标识
     * @return 接入信息集合
     */
    List<BusSystemAccess> queryBySystemPlatform(Integer platformId, Integer busPlatformId) throws Exception;

    /**
     * 查询该用户所有应用的接入信息
     *
     * @param busSystemAccessVo BusSystemAccessVo
     * @return
     */
    PageBean getPagedData(BusSystemAccessVo busSystemAccessVo) throws Exception;
}
