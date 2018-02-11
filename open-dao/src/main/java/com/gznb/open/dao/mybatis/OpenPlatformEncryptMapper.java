package com.gznb.open.dao.mybatis;

import com.gznb.open.domain.OpenPlatformEncrypt;
import com.gznb.open.domain.OpenPlatformEncryptExample;
import com.gznb.open.domain.OpenPlatformEncryptWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface OpenPlatformEncryptMapper {
    int countByExample(OpenPlatformEncryptExample example);

    int deleteByExample(OpenPlatformEncryptExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpenPlatformEncryptWithBLOBs record);

    int insertSelective(OpenPlatformEncryptWithBLOBs record);

    List<OpenPlatformEncryptWithBLOBs> selectByExampleWithBLOBsWithRowbounds(OpenPlatformEncryptExample example, RowBounds rowBounds);

    List<OpenPlatformEncryptWithBLOBs> selectByExampleWithBLOBs(OpenPlatformEncryptExample example);

    List<OpenPlatformEncrypt> selectByExampleWithRowbounds(OpenPlatformEncryptExample example, RowBounds rowBounds);

    List<OpenPlatformEncrypt> selectByExample(OpenPlatformEncryptExample example);

    OpenPlatformEncryptWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OpenPlatformEncryptWithBLOBs record, @Param("example") OpenPlatformEncryptExample example);

    int updateByExampleWithBLOBs(@Param("record") OpenPlatformEncryptWithBLOBs record, @Param("example") OpenPlatformEncryptExample example);

    int updateByExample(@Param("record") OpenPlatformEncrypt record, @Param("example") OpenPlatformEncryptExample example);

    int updateByPrimaryKeySelective(OpenPlatformEncryptWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OpenPlatformEncryptWithBLOBs record);

    int updateByPrimaryKey(OpenPlatformEncrypt record);
}