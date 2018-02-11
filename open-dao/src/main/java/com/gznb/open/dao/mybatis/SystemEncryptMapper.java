package com.gznb.open.dao.mybatis;

import com.gznb.open.domain.SystemEncrypt;
import com.gznb.open.domain.SystemEncryptExample;
import com.gznb.open.domain.SystemEncryptWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SystemEncryptMapper {
    int countByExample(SystemEncryptExample example);

    int deleteByExample(SystemEncryptExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemEncryptWithBLOBs record);

    int insertSelective(SystemEncryptWithBLOBs record);

    List<SystemEncryptWithBLOBs> selectByExampleWithBLOBsWithRowbounds(SystemEncryptExample example, RowBounds rowBounds);

    List<SystemEncryptWithBLOBs> selectByExampleWithBLOBs(SystemEncryptExample example);

    List<SystemEncrypt> selectByExampleWithRowbounds(SystemEncryptExample example, RowBounds rowBounds);

    List<SystemEncrypt> selectByExample(SystemEncryptExample example);

    SystemEncryptWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemEncryptWithBLOBs record, @Param("example") SystemEncryptExample example);

    int updateByExampleWithBLOBs(@Param("record") SystemEncryptWithBLOBs record, @Param("example") SystemEncryptExample example);

    int updateByExample(@Param("record") SystemEncrypt record, @Param("example") SystemEncryptExample example);

    int updateByPrimaryKeySelective(SystemEncryptWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SystemEncryptWithBLOBs record);

    int updateByPrimaryKey(SystemEncrypt record);
}