package com.gznb.open.service;

import com.gznb.open.domain.SystemInterface;
import com.gznb.open.domain.SystemInterfaceWithBLOBs;
import com.gznb.open.domain.custom.SystemInterfaceCustom;
import com.gznb.open.domain.vo.SystemInterfaceVo;
import com.gznb.open.domain.vo.base.PageBean;

import java.util.List;

/**
 * 系统接口模块接口
 *
 * Created by jj02 on 2017/6/29.
 */
public interface ISystemInterfaceService {

    /**
     * 查询分页数据
     * @param vo
     * @return
     */
    PageBean getPagedData(SystemInterfaceVo vo) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     * @throws Exception
     */
    int delete(Integer id) throws Exception;

    /**
     * 保存
     * @param record
     * @return
     * @throws Exception
     */
    SystemInterface save(SystemInterfaceWithBLOBs record) throws Exception;

    /**
     * 根据id获取接口信息
     * @param id
     * @return
     * @throws Exception
     */
    SystemInterfaceCustom getDataById(Integer id) throws Exception;

    /**
     * 根据模块标识查询接口列表
     * @param moduleId
     * @return
     * @throws Exception
     */
    List<SystemInterface> getDataListByModuleId(Integer moduleId) throws Exception;
}
