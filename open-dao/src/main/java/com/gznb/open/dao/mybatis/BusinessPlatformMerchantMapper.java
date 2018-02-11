package com.gznb.open.dao.mybatis;

import com.gznb.open.domain.BusinessPlatformMerchant;
import com.gznb.open.domain.BusinessPlatformMerchantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BusinessPlatformMerchantMapper {
    int countByExample(BusinessPlatformMerchantExample example);

    int deleteByExample(BusinessPlatformMerchantExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusinessPlatformMerchant record);

    int insertSelective(BusinessPlatformMerchant record);

    List<BusinessPlatformMerchant> selectByExampleWithRowbounds(BusinessPlatformMerchantExample example, RowBounds rowBounds);

    List<BusinessPlatformMerchant> selectByExample(BusinessPlatformMerchantExample example);

    BusinessPlatformMerchant selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusinessPlatformMerchant record, @Param("example") BusinessPlatformMerchantExample example);

    int updateByExample(@Param("record") BusinessPlatformMerchant record, @Param("example") BusinessPlatformMerchantExample example);

    int updateByPrimaryKeySelective(BusinessPlatformMerchant record);

    int updateByPrimaryKey(BusinessPlatformMerchant record);
}