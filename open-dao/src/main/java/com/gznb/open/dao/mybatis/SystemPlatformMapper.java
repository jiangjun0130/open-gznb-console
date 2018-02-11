package com.gznb.open.dao.mybatis;

import com.gznb.open.domain.SystemPlatform;
import com.gznb.open.domain.SystemPlatformExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SystemPlatformMapper {
    int countByExample(SystemPlatformExample example);

    int deleteByExample(SystemPlatformExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemPlatform record);

    int insertSelective(SystemPlatform record);

    List<SystemPlatform> selectByExampleWithRowbounds(SystemPlatformExample example, RowBounds rowBounds);

    List<SystemPlatform> selectByExample(SystemPlatformExample example);

    SystemPlatform selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemPlatform record, @Param("example") SystemPlatformExample example);

    int updateByExample(@Param("record") SystemPlatform record, @Param("example") SystemPlatformExample example);

    int updateByPrimaryKeySelective(SystemPlatform record);

    int updateByPrimaryKey(SystemPlatform record);
}