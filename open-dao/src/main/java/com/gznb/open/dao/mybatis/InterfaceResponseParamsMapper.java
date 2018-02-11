package com.gznb.open.dao.mybatis;

import com.gznb.open.domain.InterfaceResponseParams;
import com.gznb.open.domain.InterfaceResponseParamsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface InterfaceResponseParamsMapper {
    int countByExample(InterfaceResponseParamsExample example);

    int deleteByExample(InterfaceResponseParamsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InterfaceResponseParams record);

    int insertSelective(InterfaceResponseParams record);

    List<InterfaceResponseParams> selectByExampleWithRowbounds(InterfaceResponseParamsExample example, RowBounds rowBounds);

    List<InterfaceResponseParams> selectByExample(InterfaceResponseParamsExample example);

    InterfaceResponseParams selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InterfaceResponseParams record, @Param("example") InterfaceResponseParamsExample example);

    int updateByExample(@Param("record") InterfaceResponseParams record, @Param("example") InterfaceResponseParamsExample example);

    int updateByPrimaryKeySelective(InterfaceResponseParams record);

    int updateByPrimaryKey(InterfaceResponseParams record);
}