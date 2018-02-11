package com.gznb.open.dao.mybatis;

import com.gznb.open.domain.BusinessPlateformEncrypt;
import com.gznb.open.domain.BusinessPlateformEncryptExample;
import com.gznb.open.domain.BusinessPlateformEncryptWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BusinessPlateformEncryptMapper {
    int countByExample(BusinessPlateformEncryptExample example);

    int deleteByExample(BusinessPlateformEncryptExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusinessPlateformEncryptWithBLOBs record);

    int insertSelective(BusinessPlateformEncryptWithBLOBs record);

    List<BusinessPlateformEncryptWithBLOBs> selectByExampleWithBLOBsWithRowbounds(BusinessPlateformEncryptExample example, RowBounds rowBounds);

    List<BusinessPlateformEncryptWithBLOBs> selectByExampleWithBLOBs(BusinessPlateformEncryptExample example);

    List<BusinessPlateformEncrypt> selectByExampleWithRowbounds(BusinessPlateformEncryptExample example, RowBounds rowBounds);

    List<BusinessPlateformEncrypt> selectByExample(BusinessPlateformEncryptExample example);

    BusinessPlateformEncryptWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusinessPlateformEncryptWithBLOBs record, @Param("example") BusinessPlateformEncryptExample example);

    int updateByExampleWithBLOBs(@Param("record") BusinessPlateformEncryptWithBLOBs record, @Param("example") BusinessPlateformEncryptExample example);

    int updateByExample(@Param("record") BusinessPlateformEncrypt record, @Param("example") BusinessPlateformEncryptExample example);

    int updateByPrimaryKeySelective(BusinessPlateformEncryptWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BusinessPlateformEncryptWithBLOBs record);

    int updateByPrimaryKey(BusinessPlateformEncrypt record);
}