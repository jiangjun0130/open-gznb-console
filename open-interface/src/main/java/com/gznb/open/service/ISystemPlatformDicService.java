package com.gznb.open.service;

import com.gznb.open.domain.SystemPlatformDic;
import com.gznb.open.domain.SystemPlatformDicCatalog;
import com.gznb.open.domain.vo.SystemPlatformDicCatalogVo;
import com.gznb.open.domain.vo.base.PageBean;

import java.util.List;

/**
 * 数据字典接口
 * Created by zhenglin on 2017/7/28.
 */
public interface ISystemPlatformDicService {
    /**
     * 保存数据字典信息
     */
    SystemPlatformDicCatalog saveDic(SystemPlatformDicCatalog record) throws Exception;

    SystemPlatformDic save(SystemPlatformDic record) throws Exception;
    /**
     * 查询数据字典目录信息
     */
    SystemPlatformDicCatalog getDataByCatalogId(Integer catalogId) throws Exception;

    /**
     * 查询数据字典值信息
     */
    List<SystemPlatformDic> getDicDataBycatalogId(Integer catalogId) throws Exception;

    /**
     *更新数据字典值信息
     */
    int updatedic(SystemPlatformDic vo) throws Exception;

    /**
     * 更新数据字典目录信息
     */
    int updateCatalog(SystemPlatformDicCatalog systemPlatformDicCatalog) throws Exception;

    /**
     * 查询数据字典值信息
     */
    PageBean queryDicData(SystemPlatformDicCatalogVo systemPlatformDicCatalog) throws Exception;

    /**
     * 删除字典目录
     */
    int deleteDic(Integer dicId) throws Exception;
}
