package com.gznb.open.dao.mybatis;

import com.gznb.open.domain.SystemPlatformDicCatalog;
import com.gznb.open.domain.SystemPlatformDicCatalogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SystemPlatformDicCatalogMapper {
    int countByExample(SystemPlatformDicCatalogExample example);

    int deleteByExample(SystemPlatformDicCatalogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemPlatformDicCatalog record);

    int insertSelective(SystemPlatformDicCatalog record);

    List<SystemPlatformDicCatalog> selectByExampleWithRowbounds(SystemPlatformDicCatalogExample example, RowBounds rowBounds);

    List<SystemPlatformDicCatalog> selectByExample(SystemPlatformDicCatalogExample example);

    SystemPlatformDicCatalog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemPlatformDicCatalog record, @Param("example") SystemPlatformDicCatalogExample example);

    int updateByExample(@Param("record") SystemPlatformDicCatalog record, @Param("example") SystemPlatformDicCatalogExample example);

    int updateByPrimaryKeySelective(SystemPlatformDicCatalog record);

    int updateByPrimaryKey(SystemPlatformDicCatalog record);
}