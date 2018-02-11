package com.gznb.open.dao.mybatis;

import com.gznb.open.domain.SystemPlatformDic;
import com.gznb.open.domain.SystemPlatformDicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SystemPlatformDicMapper {
    int countByExample(SystemPlatformDicExample example);

    int deleteByExample(SystemPlatformDicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemPlatformDic record);

    int insertSelective(SystemPlatformDic record);

    List<SystemPlatformDic> selectByExampleWithRowbounds(SystemPlatformDicExample example, RowBounds rowBounds);

    List<SystemPlatformDic> selectByExample(SystemPlatformDicExample example);

    SystemPlatformDic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemPlatformDic record, @Param("example") SystemPlatformDicExample example);

    int updateByExample(@Param("record") SystemPlatformDic record, @Param("example") SystemPlatformDicExample example);

    int updateByPrimaryKeySelective(SystemPlatformDic record);

    int updateByPrimaryKey(SystemPlatformDic record);
}