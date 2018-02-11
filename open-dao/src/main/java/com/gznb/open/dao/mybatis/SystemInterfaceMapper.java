package com.gznb.open.dao.mybatis;

import com.gznb.open.domain.SystemInterface;
import com.gznb.open.domain.SystemInterfaceExample;
import com.gznb.open.domain.SystemInterfaceWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SystemInterfaceMapper {
    int countByExample(SystemInterfaceExample example);

    int deleteByExample(SystemInterfaceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemInterfaceWithBLOBs record);

    int insertSelective(SystemInterfaceWithBLOBs record);

    List<SystemInterfaceWithBLOBs> selectByExampleWithBLOBsWithRowbounds(SystemInterfaceExample example, RowBounds rowBounds);

    List<SystemInterfaceWithBLOBs> selectByExampleWithBLOBs(SystemInterfaceExample example);

    List<SystemInterface> selectByExampleWithRowbounds(SystemInterfaceExample example, RowBounds rowBounds);

    List<SystemInterface> selectByExample(SystemInterfaceExample example);

    SystemInterfaceWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemInterfaceWithBLOBs record, @Param("example") SystemInterfaceExample example);

    int updateByExampleWithBLOBs(@Param("record") SystemInterfaceWithBLOBs record, @Param("example") SystemInterfaceExample example);

    int updateByExample(@Param("record") SystemInterface record, @Param("example") SystemInterfaceExample example);

    int updateByPrimaryKeySelective(SystemInterfaceWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SystemInterfaceWithBLOBs record);

    int updateByPrimaryKey(SystemInterface record);
}