package com.gznb.open.service;

import com.gznb.open.domain.InterfaceResponseParams;
import com.gznb.open.domain.custom.InterfaceResponseParamsCustom;

import java.util.List;

/**
 * 接口响应参数服务接口
 * <p>
 * Created by jj02 on 2017/7/3.
 */
public interface IRespParamService {

    /**
     * 根据接口id获取请求参数列表
     *
     * @param interfaceId
     * @return
     * @throws Exception
     */
    List<InterfaceResponseParamsCustom> getDataListById(Integer platformId, Integer interfaceId, Integer moduleId) throws Exception;

    /**
     * 保存
     *
     * @param param
     * @return
     * @throws Exception
     */
    int save(InterfaceResponseParams param) throws Exception;

    /**
     * 删除
     *
     * @param respParamId
     * @return
     * @throws Exception
     */
    int delete(Integer respParamId) throws Exception;
}
