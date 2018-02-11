package com.gznb.open.service;

import com.gznb.open.common.constants.Constants;
import com.gznb.open.common.constants.ExceptionEnum;
import com.gznb.open.common.exception.SystemErrorException;
import com.gznb.open.dao.mybatis.InterfaceRequestParamsMapper;
import com.gznb.open.dao.mybatis.custom.InterfaceRequestParamsMapperCustom;
import com.gznb.open.domain.InterfaceRequestParams;
import com.gznb.open.domain.SystemInterface;
import com.gznb.open.domain.custom.InterfaceRequestParamsCustom;
import com.gznb.open.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 接口请求参数服务接口实现类
 * <p>
 * Created by jj02 on 2017/7/3.
 */
@Service("reqParamService")
public class ReqParamServiceImpl extends AbstractService<SystemInterfaceServiceImpl> implements IReqParamService {

    @Autowired
    private InterfaceRequestParamsMapper mapper;

    @Autowired
    private InterfaceRequestParamsMapperCustom mapperCustom;

    @Override
    public List<InterfaceRequestParamsCustom> getDataListById(Integer platformId,Integer interfaceId, Integer moduleId) throws Exception {
        if (interfaceId == null) {
            return null;
        }
        Map<String,Integer> map = new HashMap<>(2);
        map.put("platform_id",platformId);
        map.put("interface_id",interfaceId);
        map.put("module_id", moduleId);
        try {
            return mapperCustom.getDataListById(map);
        } catch (Exception e) {
            String extraMsg = "查询系统接口请求参数异常！interfaceId：" + interfaceId;
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Transactional
    @Override
    public int save(InterfaceRequestParams param) throws Exception {
        int rows = 0;
        try {
            if (param.getId() == null) {
                // insert
                rows = mapper.insertSelective(param);
            } else {
                // update
                rows = mapper.updateByPrimaryKeySelective(param);
            }
            if (rows < 1) {
                logger.warn("更新接口请求参数失败！rows: {} ^_^ record: {}", rows, param.toString());
            }
        } catch (Exception e) {
            String extraMsg = "更新接口请求参数失败！更新记录：" + param.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
        return rows;
    }

    @Transactional
    @Override
    public int delete(Integer reqParamId) throws Exception {
        if (reqParamId == null) {
            return 0;
        }
        int rows = 0;
        InterfaceRequestParams record = new InterfaceRequestParams();
        record.setId(reqParamId);
        record.setUpdateTime(new Date());
        record.setParamStatus(Constants.SYSTEM_DATA_STATUS_DELETE);
        try {
            rows = mapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            String extraMsg = "删除请求参数记录异常！reqParamId：" + reqParamId;
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
        return rows;
    }
}
