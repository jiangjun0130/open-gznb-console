package com.gznb.open.service;

import com.gznb.open.common.config.SystemConfig;
import com.gznb.open.common.constants.ExceptionEnum;
import com.gznb.open.common.exception.SystemErrorException;
import com.gznb.open.dao.mybatis.InterfaceReqParamSampleMapper;
import com.gznb.open.dao.mybatis.custom.InterfaceReqParamSampleMapperCustom;
import com.gznb.open.domain.InterfaceReqParamSample;
import com.gznb.open.domain.InterfaceReqParamSampleExample;
import com.gznb.open.service.base.AbstractService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 接口请求参数示例接口实现类
 *
 * Created by jj02 on 2017/7/6.
 */
@Service("reqParamSampleService")
public class ReqParamSampleServiceImpl extends AbstractService<ReqParamSampleServiceImpl> implements IReqParamSampleService {

    @Autowired
    private InterfaceReqParamSampleMapper mapper;

    @Autowired
    private InterfaceReqParamSampleMapperCustom mapperCustom;

    @Autowired
    private SystemConfig systemConfig;

    @Override
    public InterfaceReqParamSample getDataByInterfaceId(Integer interfaceId) throws Exception {
        if (interfaceId == null) {
            return null;
        }
        InterfaceReqParamSampleExample example = new InterfaceReqParamSampleExample();
        example.or().andInterfaceIdEqualTo(interfaceId);
        try {
            List<InterfaceReqParamSample> list = mapper.selectByExampleWithBLOBs(example);
            if (CollectionUtils.isNotEmpty(list)) {
                for (InterfaceReqParamSample imgurlList : list) {
                    String image = imgurlList.getSampleUri();
                    if (image == null) {
                        imgurlList.setSampleUri(null);
                    } else {
                        String imageUrl= systemConfig.getImageUrl() + image;
                        imgurlList.setSampleUri(imageUrl);
                    }
                }
                return list.get(0);
            }
        } catch (Exception e) {
            String extraMsg = "查询系统接口请求参数示例异常！interfaceId：" + interfaceId;
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
        return null;
    }

    @Transactional
    @Override
    public InterfaceReqParamSample save(InterfaceReqParamSample sample) throws Exception {
        int rows = 0;
        try {
            if(sample.getId() == null || sample.getId() == 0){
                // insert
                rows = mapperCustom.insertSelective(sample);
            }else{
                // update
                rows = mapper.updateByPrimaryKeySelective(sample);
            }
            if (rows < 1) {
                logger.warn("更新系统接口请求参数示例记录失败！rows: {} ^_^ record: {}", rows, sample.toString());
            }
        } catch (Exception e) {
            String extraMsg = "更新系统接口请求参数示例记录异常！新增记录：" + sample.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
        return sample;
    }
}
