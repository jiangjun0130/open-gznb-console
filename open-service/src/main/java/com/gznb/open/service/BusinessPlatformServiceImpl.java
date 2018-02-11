package com.gznb.open.service;

import com.gznb.open.common.config.SystemConfig;
import com.gznb.open.common.constants.Constants;
import com.gznb.open.common.constants.ExceptionEnum;
import com.gznb.open.common.exception.SystemErrorException;
import com.gznb.open.dao.mybatis.BusSystemApplyRecordMapper;
import com.gznb.open.dao.mybatis.BusinessPlatformMapper;
import com.gznb.open.dao.mybatis.custom.BusSystemApplyRecordMapperCustom;
import com.gznb.open.dao.mybatis.custom.BusinessPlatformMapperCustom;
import com.gznb.open.domain.BusSystemApplyRecord;
import com.gznb.open.domain.BusinessPlatform;
import com.gznb.open.domain.custom.BusinessPlatformCustom;
import com.gznb.open.domain.custom.BusinessPlatformMerchantCustom;
import com.gznb.open.domain.vo.BusSystemApplyRecordVo;
import com.gznb.open.domain.vo.BusinessPlatformVo;
import com.gznb.open.domain.vo.base.PageBean;
import com.gznb.open.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by kl09 on 2017/6/28.
 */
@Service("businessPlatformService")
public class BusinessPlatformServiceImpl extends AbstractService<BusinessPlatformServiceImpl> implements
        IBusinessPlatformService {

    @Autowired
    private BusinessPlatformMapper businessPlatformMapper;
    @Autowired
    private BusinessPlatformMapperCustom businessPlatformMapperCustom;
    @Autowired
    private BusSystemApplyRecordMapper busSystemApplyRecordMapper;
    @Autowired
    private BusSystemApplyRecordMapperCustom recordMapperCustom;
    @Autowired
    private SystemConfig systemConfig;

    @Transactional
    @Override
    public Integer  insert(BusinessPlatform bp, BusinessPlatformVo vo) {
        try {
            int insert = businessPlatformMapperCustom.insert(bp);
            int busPlatformId = bp.getId();
            logger.info("添加应用成功，返回主键：{}", busPlatformId);
            if (vo.getListId() != null && vo.getListId().size() != 0) {
                vo.getListId().forEach(s -> {
                    BusSystemApplyRecord bar = new BusSystemApplyRecord();
                    bar.setPlatformId(Integer.parseInt(s)); //平台系统ID
                    bar.setBusPlatformId(busPlatformId); //业务系统应用ID
                    bar.setApplyUser(vo.getCreateUser()); //申请人
                    bar.setApplyEmail(vo.getApplyUserEmail()); //申请人邮箱
                    bar.setApplyMobile(vo.getApplyUserPhone()); //申请人电话
                    bar.setApplyDescription(vo.getDescription()); //申请备注
                    bar.setApplyStatus(String.valueOf(Constants.APPLY_STATUS_INIT)); //申请状态。初始申请
                    try {
                        busSystemApplyRecordMapper.insertSelective(bar);
                    } catch (Exception e) {
                        logger.error("插入申请记录出错");
                    }
                });
            }
            logger.info(bp.toString());
            return busPlatformId;
        } catch (Exception e) {
            String extraMsg = "新建业务应用出错，参数:" + bp.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }

    }

    @Override
    public void update(BusinessPlatform businessPlatform) throws Exception {
        try {
            businessPlatformMapper.updateByPrimaryKey(businessPlatform);
        } catch (Exception e) {
            String extraMsg = "修改应用信息异常，参数:" + businessPlatform.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Override
    public PageBean getPagedData(BusinessPlatformVo vo) throws Exception {
        if (vo == null) {
            String extraMsg = "查询业务接入申请记录异常,查询参数userId=0";
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg);
        }
        // 查询分页数据
        calculateStartIndex(vo);
        try {
            List<BusinessPlatformCustom> recordList = businessPlatformMapperCustom.getPagedData(vo);
            Integer recordCount = businessPlatformMapperCustom.getRecordCount(vo);
            /*recordList.forEach(businessPlatformCustom -> {
                //查询该项目已申请的功能
                BusSystemApplyRecordVo busSystemApplyRecordVo = new BusSystemApplyRecordVo();
                busSystemApplyRecordVo.setBusPlatformId(businessPlatformCustom.getId());
                busSystemApplyRecordVo.setAuditResult(String.valueOf(Constants.AUDIT_RESULT_OK));
                busSystemApplyRecordVo.setPageBean(new PageBean(1, 100));
                businessPlatformCustom.setBusSystemApplyRecords(recordMapperCustom.getPagedData(busSystemApplyRecordVo));
            });*/
            return new PageBean(vo.getPageBean().getCurrentPage(), vo.getPageBean().getPageSize(), recordCount, recordList);
        } catch (Exception e) {
            String extraMsg = "查询业务接入申请记录异常,查询参数" + vo.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Override
    public PageBean getPageDataWithApply(BusinessPlatformVo vo) throws Exception {
        if (vo == null) {
            String extraMsg = "查询业务接入申请记录异常,查询参数userId=0";
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg);
        }
        // 查询分页数据
        calculateStartIndex(vo);
        try {
            List<BusinessPlatformCustom> recordList = businessPlatformMapperCustom.getPagedData(vo);
            Integer recordCount = businessPlatformMapperCustom.getRecordCount(vo);
            recordList.forEach(businessPlatformCustom -> {
                //查询该项目已申请的功能
                BusSystemApplyRecordVo busSystemApplyRecordVo = new BusSystemApplyRecordVo();
                busSystemApplyRecordVo.setBusPlatformId(businessPlatformCustom.getId());
                busSystemApplyRecordVo.setAuditResult(String.valueOf(Constants.AUDIT_RESULT_OK));
                busSystemApplyRecordVo.setPageBean(new PageBean(1, 100));
                businessPlatformCustom.setBusSystemApplyRecords(recordMapperCustom.getPagedData(busSystemApplyRecordVo));
            });
            return new PageBean(vo.getPageBean().getCurrentPage(), vo.getPageBean().getPageSize(), recordCount, recordList);
        } catch (Exception e) {
            String extraMsg = "查询业务接入申请记录异常,查询参数" + vo.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Override
    public BusinessPlatformCustom queryWithChannel(Integer businessId) {
        try {
            BusinessPlatformCustom businessPlatformCustom = businessPlatformMapperCustom.queryWithChannel(businessId,Integer.valueOf(systemConfig.getEnvFlag()));
            Optional.of(businessPlatformCustom)
                    .ifPresent(b -> {
                        b.getSystemPlatforms().forEach(systemPlatformWithEntry -> {
                            List<BusinessPlatformMerchantCustom> businessPlatformMerchantCustoms =
                                    businessPlatformMapperCustom.queryMechantWithBusniessEntry(systemPlatformWithEntry
                                            .getId(), businessId, Integer.valueOf(systemConfig.getEnvFlag()));
                            for (BusinessPlatformMerchantCustom businessPlatformMerchantCustom : businessPlatformMerchantCustoms) {
                                if (businessPlatformMerchantCustom.getBusPrivateKeyUriTest() == null) {
                                    businessPlatformMerchantCustom.setBusPrivateKeyUriTest(null);
                                } else {
                                    businessPlatformMerchantCustom.setBusPrivateKeyUriTest(systemConfig.getImageUrl()+ businessPlatformMerchantCustom.getBusPrivateKeyUriTest());
                                }
                                if (businessPlatformMerchantCustom.getBusPrivateKeyUriPrd() == null) {
                                    businessPlatformMerchantCustom.setBusPrivateKeyUriPrd(null);
                                } else {
                                    businessPlatformMerchantCustom.setBusPrivateKeyUriPrd(systemConfig.getImageUrl()+ businessPlatformMerchantCustom.getBusPrivateKeyUriPrd());
                                }
                                if (businessPlatformMerchantCustom.getBusPublicKeyUri() == null) {
                                    businessPlatformMerchantCustom.setBusPublicKeyUri(null);
                                } else {
                                    businessPlatformMerchantCustom.setBusPublicKeyUri(systemConfig.getImageUrl()+ businessPlatformMerchantCustom.getBusPublicKeyUri());
                                }
                            }
                            systemPlatformWithEntry.setMerchants(businessPlatformMerchantCustoms);
                            if (systemPlatformWithEntry.getSystemPublicKeyUriTest() == null) {
                                systemPlatformWithEntry.setSystemPublicKeyUriTest(null);
                            } else {
                                systemPlatformWithEntry.setSystemPublicKeyUriTest(systemConfig.getImageUrl()+ systemPlatformWithEntry.getSystemPublicKeyUriTest());
                            }
                            if (systemPlatformWithEntry.getSystemPublicKeyUriPrd() == null) {
                                systemPlatformWithEntry.setSystemPublicKeyUriPrd(null);
                            } else {
                                systemPlatformWithEntry.setSystemPublicKeyUriPrd(systemConfig.getImageUrl()+ systemPlatformWithEntry.getSystemPublicKeyUriPrd());
                            }
                        });
                    });
            return businessPlatformCustom;
        } catch (Exception e) {
            String extraMsg = "查询应用信息异常,查询参数businessId:" + businessId;
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }
}
