package com.gznb.open.dao.mybatis;

import com.gznb.open.domain.BusinessPlatformChannel;
import com.gznb.open.domain.BusinessPlatformChannelExample;
import com.gznb.open.domain.BusinessPlatformChannelWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BusinessPlatformChannelMapper {
    int countByExample(BusinessPlatformChannelExample example);

    int deleteByExample(BusinessPlatformChannelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusinessPlatformChannelWithBLOBs record);

    int insertSelective(BusinessPlatformChannelWithBLOBs record);

    List<BusinessPlatformChannelWithBLOBs> selectByExampleWithBLOBsWithRowbounds(BusinessPlatformChannelExample example, RowBounds rowBounds);

    List<BusinessPlatformChannelWithBLOBs> selectByExampleWithBLOBs(BusinessPlatformChannelExample example);

    List<BusinessPlatformChannel> selectByExampleWithRowbounds(BusinessPlatformChannelExample example, RowBounds rowBounds);

    List<BusinessPlatformChannel> selectByExample(BusinessPlatformChannelExample example);

    BusinessPlatformChannelWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusinessPlatformChannelWithBLOBs record, @Param("example") BusinessPlatformChannelExample example);

    int updateByExampleWithBLOBs(@Param("record") BusinessPlatformChannelWithBLOBs record, @Param("example") BusinessPlatformChannelExample example);

    int updateByExample(@Param("record") BusinessPlatformChannel record, @Param("example") BusinessPlatformChannelExample example);

    int updateByPrimaryKeySelective(BusinessPlatformChannelWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BusinessPlatformChannelWithBLOBs record);

    int updateByPrimaryKey(BusinessPlatformChannel record);
}