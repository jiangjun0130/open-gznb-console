package com.gznb.open.dao.mybatis.custom;

import com.gznb.open.domain.custom.InterfaceRequestParamsCustom;
import java.util.List;
import java.util.Map;

public interface InterfaceRequestParamsMapperCustom {

    /**
     * 根据接口id获取请求参数列表
     * @param map
     * @return
     */
    List<InterfaceRequestParamsCustom> getDataListById(Map<String,Integer> map);
}