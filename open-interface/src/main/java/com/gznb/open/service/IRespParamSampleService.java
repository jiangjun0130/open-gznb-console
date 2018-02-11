package com.gznb.open.service;

import com.gznb.open.domain.InterfaceRespParamSample;

/**
 * 接口响应参数示例接口
 *
 * Created by jj02 on 2017/7/7.
 */
public interface IRespParamSampleService {

    /**
     * 根据接口标识获取对应的接口请求参数示例
     * @param interfaceId
     * @return
     * @throws Exception
     */
    InterfaceRespParamSample getDataByInterfaceId(Integer interfaceId) throws Exception;

    /**
     * 保存
     * @param sample
     * @return
     * @throws Exception
     */
    InterfaceRespParamSample save(InterfaceRespParamSample sample) throws Exception;

}
