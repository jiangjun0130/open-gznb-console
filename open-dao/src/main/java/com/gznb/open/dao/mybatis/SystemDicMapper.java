package com.gznb.open.dao.mybatis;

import com.gznb.open.domain.SystemDic;
import com.gznb.open.domain.SystemDicExample;
import com.gznb.open.domain.SystemDicKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SystemDicMapper {
    int countByExample(SystemDicExample example);

    int deleteByExample(SystemDicExample example);

    int deleteByPrimaryKey(SystemDicKey key);

    int insert(SystemDic record);

    int insertSelective(SystemDic record);

    List<SystemDic> selectByExampleWithRowbounds(SystemDicExample example, RowBounds rowBounds);

    List<SystemDic> selectByExample(SystemDicExample example);

    SystemDic selectByPrimaryKey(SystemDicKey key);

    int updateByExampleSelective(@Param("record") SystemDic record, @Param("example") SystemDicExample example);

    int updateByExample(@Param("record") SystemDic record, @Param("example") SystemDicExample example);

    int updateByPrimaryKeySelective(SystemDic record);

    int updateByPrimaryKey(SystemDic record);
}