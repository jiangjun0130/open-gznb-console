package com.gznb.open.service;

import com.gznb.open.common.constants.ExceptionEnum;
import com.gznb.open.common.exception.SystemErrorException;
import com.gznb.open.dao.mybatis.SystemPlatformDicCatalogMapper;
import com.gznb.open.dao.mybatis.SystemPlatformDicMapper;
import com.gznb.open.dao.mybatis.custom.SystemPlatformDicCatalogMapperCustom;
import com.gznb.open.dao.mybatis.custom.SystemPlatformDicMapperCustom;
import com.gznb.open.domain.SystemPlatformDic;
import com.gznb.open.domain.SystemPlatformDicCatalog;
import com.gznb.open.domain.custom.SystemPlatformCustom;
import com.gznb.open.domain.custom.SystemPlatformDicCatalogCustom;
import com.gznb.open.domain.vo.SystemPlatformDicCatalogVo;
import com.gznb.open.domain.vo.SystemPlatformVo;
import com.gznb.open.domain.vo.base.PageBean;
import com.gznb.open.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhenglin on 2017/7/28.
 */
@Service("systemPlatformDicService")
public class SystemPlatformDicServiceImpl extends AbstractService<SystemPlatformDicServiceImpl> implements ISystemPlatformDicService {

    @Autowired
   private SystemPlatformDicCatalogMapperCustom systemPlatformDicCatalogMapperCustom;

    @Autowired
    private SystemPlatformDicCatalogMapper systemPlatformDicCatalogMapper;

    @Autowired
    private SystemPlatformDicMapperCustom systemPlatformDicMapperCustom;

    @Autowired
    private SystemPlatformDicMapper systemPlatformDicMapper;

    @Transactional
    @Override
    public SystemPlatformDicCatalog saveDic(SystemPlatformDicCatalog record) throws Exception {
        int rows = 0;
        try {
            if (record.getId() == null || record.getId() == 0) {
                // insert
                rows = systemPlatformDicCatalogMapperCustom.insertSelective(record);
            } else {
                // update
                rows = systemPlatformDicCatalogMapper.updateByPrimaryKeySelective(record);
            }
            if (rows < 1) {
                logger.warn("更新数据字典记录失败！rows: {} ^_^ record: {}", rows, record.toString());
            }
        } catch (Exception e) {
            String extraMsg = "更新数据字典记录异常！新增记录：" + record.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
        return record;
    }

    @Transactional
    @Override
    public SystemPlatformDic save(SystemPlatformDic sample) throws Exception {
        int rows = 0;
        try {
            if(sample.getId() == null || sample.getId() == 0){
                // insert
                rows = systemPlatformDicMapperCustom.insertSelective(sample);
            }else{
                // update
                rows = systemPlatformDicMapper.updateByPrimaryKeySelective(sample);
            }
            if (rows < 1) {
                logger.warn("更新数据字典信息失败！rows: {} ^_^ record: {}", rows, sample.toString());
            }
        } catch (Exception e) {
            String extraMsg = "更新数据字典记录异常！新增记录：" + sample.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
        return sample;
    }
    @Override
    public  SystemPlatformDicCatalog getDataByCatalogId(Integer catalogId) throws Exception{
       if (catalogId == null) {
           return null;
       } else {
           try {
               SystemPlatformDicCatalog record = systemPlatformDicCatalogMapperCustom.getDataByCatalogId(catalogId);
               return record;
           } catch (Exception e) {
               String extraMsg = "根据字典目录id查询指定字典目录信息异常！id：" + catalogId;
               throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                       ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                       extraMsg, e);
           }
       }

    }
    @Override
    public List<SystemPlatformDic> getDicDataBycatalogId(Integer catalogId) throws Exception {
        if (catalogId == null) {
            return null;
        } else {
            try {
                return systemPlatformDicMapperCustom.getDicDataBycatalogId(catalogId);
            } catch (Exception e) {
                String extraMsg = "查询查询数据字典值信息异常！catalogId：" + catalogId;
                throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                        ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                        extraMsg, e);
            }
        }

    }
    @Override
    public int updatedic(SystemPlatformDic vo) throws Exception {
        int result = 0;
        try {
            result = systemPlatformDicMapperCustom.updatedic(vo);
        } catch (Exception e) {
            String extraMsg = "更新数据字典信息异常！更新参数：" + vo.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
        return result;

    }
    @Override
    public int updateCatalog(SystemPlatformDicCatalog systemPlatformDicCatalog) throws Exception {
       int updateresule = 0;
        try {
            updateresule = systemPlatformDicCatalogMapperCustom.updateCatalog(systemPlatformDicCatalog);
        } catch (Exception e) {
            String extraMsg = "更新数据字典目录信息异常！更新参数：" + systemPlatformDicCatalog.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
        return updateresule;
    }

    @Override
    public PageBean queryDicData(SystemPlatformDicCatalogVo systemPlatformDicCatalog) throws Exception {
        // 查询分页数据
        calculateStartIndex(systemPlatformDicCatalog);
        try {
            List<SystemPlatformDicCatalogCustom> recordList = systemPlatformDicCatalogMapperCustom.getPagedData(systemPlatformDicCatalog);
            // 查询分页总数
            Integer recordCount = systemPlatformDicCatalogMapperCustom.getRecordCount(systemPlatformDicCatalog);
            return new PageBean(systemPlatformDicCatalog.getPageBean().getCurrentPage(), systemPlatformDicCatalog.getPageBean().getPageSize(), recordCount, recordList);
        } catch (Exception e) {
            String extraMsg = "查询系统数据字典信息异常！查询参数：" + systemPlatformDicCatalog.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    public int deleteDic(Integer dicId) throws Exception{
        if (dicId == null) {
            return 0;
        }
        int result = 0;
        try {
            result = systemPlatformDicMapperCustom.deleteDic(dicId);
        } catch (Exception e) {
            String extraMsg = "删除数据字典信息异常！删除参数：" + dicId.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
        return result;
    }
}
