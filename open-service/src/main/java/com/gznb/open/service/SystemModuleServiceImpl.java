package com.gznb.open.service;

import com.gznb.open.common.constants.Constants;
import com.gznb.open.common.constants.ExceptionEnum;
import com.gznb.open.common.exception.SystemErrorException;
import com.gznb.open.dao.mybatis.SystemModuleMapper;
import com.gznb.open.dao.mybatis.custom.SystemModuleMapperCustom;
import com.gznb.open.domain.SystemModule;
import com.gznb.open.domain.SystemModuleExample;
import com.gznb.open.domain.custom.SystemModuleCustom;
import com.gznb.open.domain.vo.SystemModuleVo;
import com.gznb.open.domain.vo.base.PageBean;
import com.gznb.open.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 系统平台模块接口实现类
 * <p>
 * Created by jj02 on 2017/6/28.
 */
@Service("systemModuleService")
public class SystemModuleServiceImpl extends AbstractService<SystemPlatformImpl> implements ISystemModuleService {

    @Autowired
    private SystemModuleMapper mapper;

    @Autowired
    private SystemModuleMapperCustom mapperCustom;

    @Override
    public PageBean getPagedData(SystemModuleVo vo) throws Exception {
        calculateStartIndex(vo);
        try {
            List<SystemModuleCustom> recordList = mapperCustom.getPagedData(vo);
            // 查询分页总数
            Integer recordCount = mapperCustom.getRecordCount(vo);
            return new PageBean(vo.getPageBean().getCurrentPage(), vo.getPageBean().getPageSize(), recordCount, recordList);
        } catch (Exception e) {
            String extraMsg = "查询系统平台模块记录异常！查询参数：" + vo.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Transactional
    @Override
    public int delete(Integer id) throws Exception {
        if (id == null) {
            return 0;
        }
        int rows = 0;
        SystemModule record = new SystemModule();
        record.setId(id);
        record.setUpdateTime(new Date());
        record.setModuleStatus(Constants.SYSTEM_DATA_STATUS_DELETE);
        try {
            rows = mapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            String extraMsg = "删除系统模块记录异常！删除参数：" + record.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
        return rows;
    }

    @Transactional
    @Override
    public int save(SystemModule module) throws Exception {
        int rows = 0;
        try {
            if (module.getId() == null) {
                // insert
                rows = mapper.insertSelective(module);
            } else {
                // update
                rows = mapper.updateByPrimaryKeySelective(module);
            }
            if (rows < 1) {
                logger.warn("更新系统模块记录失败！rows: {} ^_^ record: {}", rows, module.toString());
            }
        } catch (Exception e) {
            String extraMsg = "更新系统模块记录异常！新增记录：" + module.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
        return rows;
    }

    @Override
    public List<SystemModule> queryDataByPlatformId(Integer platformId) {
        if (platformId == null) {
            return null;
        }
        SystemModuleExample example = new SystemModuleExample();
        example.or().andPlatformIdEqualTo(platformId);
        try {
            List<SystemModule> moduleList = mapper.selectByExample(example);
            return moduleList;
        } catch (Exception e) {
            String extraMsg = "根据系统标识查询系统模块记录异常！platformId：" + platformId;
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Override
    public List<SystemModuleCustom> queryModuleAndInterfaceListByPlatformId(Integer platformId) {
        if (platformId == null) {
            return null;
        }
        List<SystemModuleCustom> moduleList = null;
        try {
            moduleList = mapperCustom.queryModuleAndInterfaceListByPlatformId(platformId);
            return moduleList;
        } catch (Exception e) {
            String extraMsg = "根据系统标识查询系统模块及接口列表信息异常！platformId：" + platformId;
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }
}
