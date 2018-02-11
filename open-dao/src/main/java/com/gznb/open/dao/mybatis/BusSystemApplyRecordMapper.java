package com.gznb.open.dao.mybatis;

import com.gznb.open.domain.BusSystemApplyRecord;
import com.gznb.open.domain.BusSystemApplyRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BusSystemApplyRecordMapper {
    int countByExample(BusSystemApplyRecordExample example);

    int deleteByExample(BusSystemApplyRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusSystemApplyRecord record);

    int insertSelective(BusSystemApplyRecord record);

    List<BusSystemApplyRecord> selectByExampleWithRowbounds(BusSystemApplyRecordExample example, RowBounds rowBounds);

    List<BusSystemApplyRecord> selectByExample(BusSystemApplyRecordExample example);

    BusSystemApplyRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusSystemApplyRecord record, @Param("example") BusSystemApplyRecordExample example);

    int updateByExample(@Param("record") BusSystemApplyRecord record, @Param("example") BusSystemApplyRecordExample example);

    int updateByPrimaryKeySelective(BusSystemApplyRecord record);

    int updateByPrimaryKey(BusSystemApplyRecord record);
}