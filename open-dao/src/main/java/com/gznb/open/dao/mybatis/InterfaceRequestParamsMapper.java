package com.gznb.open.dao.mybatis;

import com.gznb.open.domain.InterfaceRequestParams;
import com.gznb.open.domain.InterfaceRequestParamsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface InterfaceRequestParamsMapper {
    int countByExample(InterfaceRequestParamsExample example);

    int deleteByExample(InterfaceRequestParamsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InterfaceRequestParams record);

    int insertSelective(InterfaceRequestParams record);

    List<InterfaceRequestParams> selectByExampleWithRowbounds(InterfaceRequestParamsExample example, RowBounds rowBounds);

    List<InterfaceRequestParams> selectByExample(InterfaceRequestParamsExample example);

    InterfaceRequestParams selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InterfaceRequestParams record, @Param("example") InterfaceRequestParamsExample example);

    int updateByExample(@Param("record") InterfaceRequestParams record, @Param("example") InterfaceRequestParamsExample example);

    int updateByPrimaryKeySelective(InterfaceRequestParams record);

    int updateByPrimaryKey(InterfaceRequestParams record);
}