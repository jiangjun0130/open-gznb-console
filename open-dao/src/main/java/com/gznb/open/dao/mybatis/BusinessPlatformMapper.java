package com.gznb.open.dao.mybatis;

import com.gznb.open.domain.BusinessPlatform;
import com.gznb.open.domain.BusinessPlatformExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BusinessPlatformMapper {
    int countByExample(BusinessPlatformExample example);

    int deleteByExample(BusinessPlatformExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusinessPlatform record);

    int insertSelective(BusinessPlatform record);

    List<BusinessPlatform> selectByExampleWithRowbounds(BusinessPlatformExample example, RowBounds rowBounds);

    List<BusinessPlatform> selectByExample(BusinessPlatformExample example);

    BusinessPlatform selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusinessPlatform record, @Param("example") BusinessPlatformExample example);

    int updateByExample(@Param("record") BusinessPlatform record, @Param("example") BusinessPlatformExample example);

    int updateByPrimaryKeySelective(BusinessPlatform record);

    int updateByPrimaryKey(BusinessPlatform record);
}