package com.gznb.open.service;

import com.gznb.open.domain.InterfaceRequestParams;
import com.gznb.open.domain.custom.InterfaceRequestParamsCustom;

import java.util.List;

/**
 * 接口请求参数服务接口
 *
 * Created by jj02 on 2017/7/3.
 */
public interface IReqParamService {

    /**
     * 根据接口id获取请求参数列表
     * @param interfaceId
     * @return
     * @throws Exception
     */
    List<InterfaceRequestParamsCustom> getDataListById(Integer platformId,Integer interfaceId, Integer moduleId) throws Exception;

    /**
     * 保存
     * @param param
     * @return
     * @throws Exception
     */
    int save(InterfaceRequestParams param) throws Exception;

    /**
     * 删除
     * @param reqParamId
     * @return
     * @throws Exception
     */
    int delete(Integer reqParamId) throws Exception;
}
