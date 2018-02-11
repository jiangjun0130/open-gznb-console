package com.gznb.open.service;

import com.gznb.open.domain.InterfaceReqParamSample;

/**
 * 接口请求参数示例接口
 *
 * Created by jj02 on 2017/7/6.
 */
public interface IReqParamSampleService {

    /**
     * 根据接口标识获取对应的接口请求参数示例
     * @param interfaceId
     * @return
     * @throws Exception
     */
    InterfaceReqParamSample getDataByInterfaceId(Integer interfaceId) throws Exception;

    /**
     * 保存
     * @param sample
     * @return
     * @throws Exception
     */
    InterfaceReqParamSample save(InterfaceReqParamSample sample) throws Exception;
}
