package com.gznb.open.service;

import com.gznb.open.domain.SystemModule;
import com.gznb.open.domain.custom.SystemModuleCustom;
import com.gznb.open.domain.vo.SystemModuleVo;
import com.gznb.open.domain.vo.base.PageBean;

import java.util.List;

/**
 * 系统平台模块接口
 *
 * Created by jj02 on 2017/6/15.
 */
public interface ISystemModuleService {

    /**
     * 查询分页数据
     * @param vo
     * @return
     */
    PageBean getPagedData(SystemModuleVo vo) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     * @throws Exception
     */
    int delete(Integer id) throws Exception;

    /**
     * 保存
     * @param module
     * @return
     * @throws Exception
     */
    int save(SystemModule module) throws Exception;

    /**
     * 根据系统id获取模块信息
     * @param platformId
     * @return
     */
    List<SystemModule> queryDataByPlatformId(Integer platformId);

    /**
     * 根据平台标识查询模块列表及其下接口列表信息
     * @param platformId
     * @return
     */
    List<SystemModuleCustom> queryModuleAndInterfaceListByPlatformId(Integer platformId);
}
