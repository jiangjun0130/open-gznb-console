package com.gznb.open.dao.mybatis.custom;

import com.gznb.open.domain.SystemPlatformDicCatalog;
import com.gznb.open.domain.custom.SystemPlatformDicCatalogCustom;
import com.gznb.open.domain.vo.SystemPlatformDicCatalogVo;

import java.util.List;

/**
 * Created by zhenglin on 2017/7/28.
 */
public interface SystemPlatformDicCatalogMapperCustom {
    /**
     * 插入数据字典信息
     * @param record
     * @return
     */
    int insertSelective(SystemPlatformDicCatalog record);

    SystemPlatformDicCatalog getDataByCatalogId(Integer catalogId);

    int updateCatalog(SystemPlatformDicCatalog systemPlatformDicCatalog);


    /**
     * 获取分页数据
     * @param vo
     * @return
     */
    List<SystemPlatformDicCatalogCustom> getPagedData(SystemPlatformDicCatalogVo vo);

    /**
     * 获取记录数
     * @param vo
     * @return
     */
    Integer getRecordCount(SystemPlatformDicCatalogVo vo);
}
