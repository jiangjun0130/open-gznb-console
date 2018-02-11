package com.gznb.open.dao.mybatis.custom;

import com.gznb.open.domain.custom.InterfaceResponseParamsCustom;
import java.util.List;
import java.util.Map;

public interface InterfaceResponseParamsMapperCustom {

    /**
     * 根据接口id获取请求参数列表
     * @param map
     * @return
     */
    List<InterfaceResponseParamsCustom> getDataListById(Map<String,Integer> map);
}