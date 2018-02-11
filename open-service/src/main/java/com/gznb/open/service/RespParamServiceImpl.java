package com.gznb.open.service;

import com.gznb.open.common.constants.Constants;
import com.gznb.open.common.constants.ExceptionEnum;
import com.gznb.open.common.exception.SystemErrorException;
import com.gznb.open.dao.mybatis.InterfaceResponseParamsMapper;
import com.gznb.open.dao.mybatis.custom.InterfaceResponseParamsMapperCustom;
import com.gznb.open.domain.InterfaceResponseParams;
import com.gznb.open.domain.custom.InterfaceResponseParamsCustom;
import com.gznb.open.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 接口响应参数服务接口实现类
 * <p>
 * Created by jj02 on 2017/7/5.
 */
@Service("respParamService")
public class RespParamServiceImpl extends AbstractService<RespParamServiceImpl> implements IRespParamService {

    @Autowired
    private InterfaceResponseParamsMapper mapper;

    @Autowired
    private InterfaceResponseParamsMapperCustom mapperCustom;

    @Override
    public List<InterfaceResponseParamsCustom> getDataListById(Integer platformId,Integer interfaceId, Integer moduleId) throws Exception {
        if (platformId == null || interfaceId == null) {
            return null;
        }
        Map<String,Integer> map = new HashMap<>(2);
        map.put("platform_id",platformId);
        map.put("interface_id",interfaceId);
        map.put("module_id", moduleId);
        try {
            return mapperCustom.getDataListById(map);
        } catch (Exception e) {
            String extraMsg = "查询系统接口响应参数异常！interfaceId：" + interfaceId;
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Transactional
    @Override
    public int save(InterfaceResponseParams param) throws Exception {
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
                logger.warn("更新接口响应参数失败！rows: {} ^_^ record: {}", rows, param.toString());
            }
        } catch (Exception e) {
            String extraMsg = "更新接口响应参数失败！更新记录：" + param.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
        return rows;
    }

    @Transactional
    @Override
    public int delete(Integer respParamId) throws Exception {
        if (respParamId == null) {
            return 0;
        }
        int rows = 0;
        InterfaceResponseParams record = new InterfaceResponseParams();
        record.setId(respParamId);
        record.setUpdateTime(new Date());
        record.setParamStatus(Constants.SYSTEM_DATA_STATUS_DELETE);
        try {
            rows = mapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            String extraMsg = "删除请求参数记录异常！respParamId：" + respParamId;
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
        return rows;
    }
}
