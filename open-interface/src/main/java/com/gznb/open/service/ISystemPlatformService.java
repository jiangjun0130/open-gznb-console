package com.gznb.open.service;

import com.gznb.open.domain.SystemPlatform;
import com.gznb.open.domain.custom.SystemPlantformDicCustom;
import com.gznb.open.domain.custom.SystemPlatformDicCatalogCustom;
import com.gznb.open.domain.vo.SystemModuleVo;
import com.gznb.open.domain.vo.SystemPlatformVo;
import com.gznb.open.domain.vo.base.PageBean;

import java.util.List;

/**
 * 系统平台服务接口
 *
 * Created by jj02 on 2017/6/15.
 */
public interface ISystemPlatformService {

    /**
     * 更新
     * @param plateform
     * @return
     */
    int update(SystemPlatform plateform) throws Exception;

    /**
     * 查询分页数据
     * @param vo
     * @return
     */
    PageBean getPagedData(SystemPlatformVo vo) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     * @throws Exception
     */
    int delete(Integer id) throws Exception;

    /**
     * 根据id获取信息
     * @param id
     * @return
     * @throws Exception
     */
    SystemPlatform getDataById(Integer id) throws Exception;

    /**
     * 根据id查询平台数据字典信息
     */
    List<SystemPlatformDicCatalogCustom> getDatadictionaryById(SystemModuleVo vo) throws Exception;
}
