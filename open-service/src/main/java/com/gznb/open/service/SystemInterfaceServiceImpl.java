package com.gznb.open.service;

import com.gznb.open.common.constants.Constants;
import com.gznb.open.common.constants.ExceptionEnum;
import com.gznb.open.common.exception.SystemErrorException;
import com.gznb.open.dao.mybatis.SystemInterfaceMapper;
import com.gznb.open.dao.mybatis.custom.SystemInterfaceMapperCustom;
import com.gznb.open.domain.SystemInterface;
import com.gznb.open.domain.SystemInterfaceExample;
import com.gznb.open.domain.SystemInterfaceWithBLOBs;
import com.gznb.open.domain.SystemPlatform;
import com.gznb.open.domain.custom.SystemInterfaceCustom;
import com.gznb.open.domain.vo.SystemInterfaceVo;
import com.gznb.open.domain.vo.base.PageBean;
import com.gznb.open.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 系统接口模块接口实现类
 *
 * Created by jj02 on 2017/6/29.
 */
@Service("systemInterfaceService")
public class SystemInterfaceServiceImpl extends AbstractService<SystemInterfaceServiceImpl> implements ISystemInterfaceService {

    @Autowired
    private SystemInterfaceMapper mapper;

    @Autowired
    private SystemInterfaceMapperCustom mapperCustom;

    @Override
    public PageBean getPagedData(SystemInterfaceVo vo) throws Exception {
        calculateStartIndex(vo);
        try{
            List<SystemInterfaceCustom> recordList = mapperCustom.getPagedData(vo);
            // 查询分页总数
            Integer recordCount = mapperCustom.getRecordCount(vo);
            return new PageBean(vo.getPageBean().getCurrentPage(),vo.getPageBean().getPageSize(),recordCount,recordList);
        }catch (Exception e){
            String extraMsg = "查询系统接口记录异常！查询参数：" + vo.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Transactional
    @Override
    public int delete(Integer id) throws Exception {
        if(id == null){
            return 0;
        }
        int rows = 0;
        SystemInterfaceWithBLOBs record = new SystemInterfaceWithBLOBs();
        record.setId(id);
        record.setUpdateTime(new Date());
        record.setInterfaceStatus(Constants.SYSTEM_DATA_STATUS_DELETE);
        try {
            rows = mapper.updateByPrimaryKeySelective(record);
        }catch (Exception e){
            String extraMsg = "删除系统接口记录异常！删除参数：" + record.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
        return rows;
    }

    @Transactional
    @Override
    public SystemInterface save(SystemInterfaceWithBLOBs record) throws Exception {
        int rows = 0;
        try {
            if(record.getId() == null || record.getId() == 0){
                // insert
                rows = mapperCustom.insertSelective(record);
            }else{
                // update
                rows = mapper.updateByPrimaryKeySelective(record);
            }
            if (rows < 1) {
                logger.warn("更新系统接口记录失败！rows: {} ^_^ record: {}", rows, record.toString());
            }
        } catch (Exception e) {
            String extraMsg = "更新系统接口记录异常！新增记录：" + record.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
        return record;
    }

    @Override
    public SystemInterfaceCustom getDataById(Integer id) throws Exception {
        if(id == null) {
            return null;
        }
        try {
            SystemInterfaceCustom record = mapperCustom.getDataById(id);
            return record;
        } catch (Exception e) {
            String extraMsg = "查询指定系统接口记录异常！id：" + id;
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Override
    public List<SystemInterface> getDataListByModuleId(Integer moduleId) throws Exception {
        if(moduleId == null){
            return null;
        }
        SystemInterfaceExample example = new SystemInterfaceExample();
        example.or().andModuleIdEqualTo(moduleId);
        try {
            List<SystemInterface> dataList = mapper.selectByExample(example);
            return dataList;
        } catch (Exception e) {
            String extraMsg = "查询系统接口记录异常！moduleId：" + moduleId;
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }
}
