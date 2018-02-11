package com.gznb.open.dao.mybatis;

import com.gznb.open.domain.BusSystemAccess;
import com.gznb.open.domain.BusSystemAccessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BusSystemAccessMapper {
    int countByExample(BusSystemAccessExample example);

    int deleteByExample(BusSystemAccessExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusSystemAccess record);

    int insertSelective(BusSystemAccess record);

    List<BusSystemAccess> selectByExampleWithRowbounds(BusSystemAccessExample example, RowBounds rowBounds);

    List<BusSystemAccess> selectByExample(BusSystemAccessExample example);

    BusSystemAccess selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusSystemAccess record, @Param("example") BusSystemAccessExample example);

    int updateByExample(@Param("record") BusSystemAccess record, @Param("example") BusSystemAccessExample example);

    int updateByPrimaryKeySelective(BusSystemAccess record);

    int updateByPrimaryKey(BusSystemAccess record);
}