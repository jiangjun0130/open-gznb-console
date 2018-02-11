package com.gznb.open.dao.mybatis;

import com.gznb.open.domain.InterfaceRespParamSample;
import com.gznb.open.domain.InterfaceRespParamSampleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface InterfaceRespParamSampleMapper {
    int countByExample(InterfaceRespParamSampleExample example);

    int deleteByExample(InterfaceRespParamSampleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InterfaceRespParamSample record);

    int insertSelective(InterfaceRespParamSample record);

    List<InterfaceRespParamSample> selectByExampleWithBLOBsWithRowbounds(InterfaceRespParamSampleExample example, RowBounds rowBounds);

    List<InterfaceRespParamSample> selectByExampleWithBLOBs(InterfaceRespParamSampleExample example);

    List<InterfaceRespParamSample> selectByExampleWithRowbounds(InterfaceRespParamSampleExample example, RowBounds rowBounds);

    List<InterfaceRespParamSample> selectByExample(InterfaceRespParamSampleExample example);

    InterfaceRespParamSample selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InterfaceRespParamSample record, @Param("example") InterfaceRespParamSampleExample example);

    int updateByExampleWithBLOBs(@Param("record") InterfaceRespParamSample record, @Param("example") InterfaceRespParamSampleExample example);

    int updateByExample(@Param("record") InterfaceRespParamSample record, @Param("example") InterfaceRespParamSampleExample example);

    int updateByPrimaryKeySelective(InterfaceRespParamSample record);

    int updateByPrimaryKeyWithBLOBs(InterfaceRespParamSample record);

    int updateByPrimaryKey(InterfaceRespParamSample record);
}