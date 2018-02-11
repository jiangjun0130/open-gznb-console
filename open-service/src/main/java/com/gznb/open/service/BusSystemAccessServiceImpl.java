package com.gznb.open.service;

import com.gznb.open.common.constants.ExceptionEnum;
import com.gznb.open.common.exception.SystemErrorException;
import com.gznb.open.dao.mybatis.BusSystemAccessMapper;
import com.gznb.open.dao.mybatis.custom.BusSystemAccessMapperCustom;
import com.gznb.open.domain.BusSystemAccess;
import com.gznb.open.domain.BusSystemAccessExample;
import com.gznb.open.domain.custom.BusSystemAccessCustom;
import com.gznb.open.domain.vo.BusSystemAccessVo;
import com.gznb.open.domain.vo.base.PageBean;
import com.gznb.open.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kl09 on 2017/6/28.
 */
@Service("busSystemAccessService")
public class BusSystemAccessServiceImpl extends AbstractService<BusSystemAccessServiceImpl> implements
        IBusSystemAccessService {

    @Autowired
    private BusSystemAccessMapper busSystemAccessMapper;
    @Autowired
    private BusSystemAccessMapperCustom busSystemAccessMapperCustom;

    @Override
    public List<BusSystemAccess> queryBySystemPlatform(Integer platformId, Integer busPlatformId) throws Exception {
        BusSystemAccessExample bsae = new BusSystemAccessExample();
        bsae.or()
                .andPlatformIdEqualTo(platformId)
                .andBusPlatformIdEqualTo(busPlatformId);
        try {
            return busSystemAccessMapper.selectByExample(bsae);
        } catch (Exception e) {
            String extraMsg = "查询应用接入功能出错";
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Override
    public PageBean getPagedData(BusSystemAccessVo vo) throws Exception {
        if (vo == null) {
            String extraMsg = "查询应用接入功能出错,查询参数userId=0";
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg);
        }
        // 查询分页数据
        calculateStartIndex(vo);
        try {
            List<BusSystemAccessCustom> recordList = busSystemAccessMapperCustom.getPagedData(vo);
            Integer recordCount = busSystemAccessMapperCustom.getRecordCount(vo);
            return new PageBean(vo.getPageBean().getCurrentPage(), vo.getPageBean().getPageSize(),
                    recordCount, recordList);
        } catch (Exception e) {
            String extraMsg = "查询应用接入功能出错,查询参数" + vo.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }
}
