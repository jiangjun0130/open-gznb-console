package com.gznb.open.dao.mybatis;

import com.gznb.open.domain.InterfaceReqParamSample;
import com.gznb.open.domain.InterfaceReqParamSampleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface InterfaceReqParamSampleMapper {
    int countByExample(InterfaceReqParamSampleExample example);

    int deleteByExample(InterfaceReqParamSampleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InterfaceReqParamSample record);

    int insertSelective(InterfaceReqParamSample record);

    List<InterfaceReqParamSample> selectByExampleWithBLOBsWithRowbounds(InterfaceReqParamSampleExample example, RowBounds rowBounds);

    List<InterfaceReqParamSample> selectByExampleWithBLOBs(InterfaceReqParamSampleExample example);

    List<InterfaceReqParamSample> selectByExampleWithRowbounds(InterfaceReqParamSampleExample example, RowBounds rowBounds);

    List<InterfaceReqParamSample> selectByExample(InterfaceReqParamSampleExample example);

    InterfaceReqParamSample selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InterfaceReqParamSample record, @Param("example") InterfaceReqParamSampleExample example);

    int updateByExampleWithBLOBs(@Param("record") InterfaceReqParamSample record, @Param("example") InterfaceReqParamSampleExample example);

    int updateByExample(@Param("record") InterfaceReqParamSample record, @Param("example") InterfaceReqParamSampleExample example);

    int updateByPrimaryKeySelective(InterfaceReqParamSample record);

    int updateByPrimaryKeyWithBLOBs(InterfaceReqParamSample record);

    int updateByPrimaryKey(InterfaceReqParamSample record);
}