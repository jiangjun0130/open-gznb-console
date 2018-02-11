package com.gznb.open.dao.mybatis.custom;

import com.gznb.open.domain.SystemPlatformDic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhenglin on 2017/7/28.
 */
public interface SystemPlatformDicMapperCustom {
    /**
     * 插入数据字典信息
     * @param sample
     * @return
     */
    int insertSelective(SystemPlatformDic sample);

    List<SystemPlatformDic> getDicDataBycatalogId(Integer catalogId);

    int updatedic(SystemPlatformDic vo);

    /**
     * 删除平台项目字典信息
     */
    int deleteDic(@Param(value = "dicId") Integer dicId);
}
