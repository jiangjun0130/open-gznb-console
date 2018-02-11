package com.gznb.open.service;

import com.gznb.open.common.config.SystemConfig;
import com.gznb.open.common.constants.Constants;
import com.gznb.open.common.constants.ExceptionEnum;
import com.gznb.open.common.exception.SystemErrorException;
import com.gznb.open.common.utils.RSAUtils;
import com.gznb.open.common.utils.UUIDUtils;
import com.gznb.open.dao.mybatis.*;
import com.gznb.open.dao.mybatis.custom.BusSystemApplyRecordMapperCustom;
import com.gznb.open.dao.mybatis.custom.BusinessPlateformEncryptMapperCustom;
import com.gznb.open.dao.mybatis.custom.BusinessPlatformMerchantMapperCustom;
import com.gznb.open.domain.*;
import com.gznb.open.domain.custom.BusSystemApplyRecordCustom;
import com.gznb.open.domain.custom.SystemPlatformCustom;
import com.gznb.open.domain.manual.EnvironmentEnum;
import com.gznb.open.domain.vo.BusSystemApplyRecordVo;
import com.gznb.open.domain.vo.base.PageBean;
import com.gznb.open.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 业务申请记录
 * Created by kl09 on 2017/6/30.
 */
@Service("busSystemApplyRecordService")
public class BusSystemApplyRecordServiceImpl extends AbstractService<BusSystemApplyRecordServiceImpl> implements
        IBusSystemApplyRecordService {

    @Autowired
    private BusSystemApplyRecordMapper recordMapper;
    @Autowired
    private BusSystemApplyRecordMapperCustom recordMapperCustom;
    @Autowired
    private SystemPlatformMapper systemPlatformMapper;
    @Autowired
    private BusinessPlatformMapper businessPlatformMapper;
    @Autowired
    private BusSystemApplyRecordMapper busSystemApplyRecordMapper;
    @Autowired
    private BusinessPlatformMerchantMapper businessPlatformMerchantMapper;
    @Autowired
    private BusinessPlatformMerchantMapperCustom businessPlatformMerchantMapperCustom;
    @Autowired
    private BusinessPlateformEncryptMapper businessPlateformEncryptMapper;
    @Autowired
    private BusinessPlateformEncryptMapperCustom businessPlateformEncryptMapperCustom;
    @Autowired
    private SystemEncryptMapper systemEncryptMapper;
    @Autowired
    private IUploadService iUploadService;
    @Autowired
    private SystemConfig systemConfig;

    @Override
    public PageBean getPagedData(BusSystemApplyRecordVo vo) throws Exception {
        if (vo == null) {
            String extraMsg = "查询业务接入申请记录异常,查询参数userId=0";
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg);
        }
        // 查询分页数据
        calculateStartIndex(vo);
        try {
            List<BusSystemApplyRecordCustom> recordList = recordMapperCustom.getPagedData(vo);
            Integer recordCount = recordMapperCustom.getRecordCount(vo);
            return new PageBean(vo.getPageBean().getCurrentPage(), vo.getPageBean().getPageSize(), recordCount, recordList);
        } catch (Exception e) {
            String extraMsg = "查询业务接入申请记录异常,查询参数" + vo.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Override
    @Transactional
    public void save(BusSystemApplyRecord busSystemApplyRecord) throws Exception {
        try {
            recordMapper.insertSelective(busSystemApplyRecord);
        } catch (Exception e) {
            String extraMsg = "插入业务系统申请记录异常,参数" + busSystemApplyRecord.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Override
    public List<SystemPlatform> queryMayApply(Integer buisnessSystemId) throws Exception {
        //1、根据业务系统ID查询该应用已经申请的功能(审核通过或者正在审核中的)
        BusSystemApplyRecordExample bsare = new BusSystemApplyRecordExample();
        bsare.or()
                .andBusPlatformIdEqualTo(buisnessSystemId)//业务系统ID
                .andAuditResultEqualTo(Constants.AUDIT_RESULT_OK); //状态：审核通过
        List<BusSystemApplyRecord> busSystemApplyRecords = recordMapper.selectByExample(bsare);
        List<Integer> systemPlatFormIds = busSystemApplyRecords.stream()
                .map(BusSystemApplyRecord::getPlatformId)
                .distinct()
                .collect(Collectors.toList());

        //2、根据已选择的功能查询还可以申请的功能
        SystemPlatformExample spe = new SystemPlatformExample();
        if (systemPlatFormIds.size() != 0) {
            spe.or().andIdNotIn(systemPlatFormIds);
        }
        try {
            return systemPlatformMapper.selectByExample(spe);
        } catch (Exception e) {
            String extraMsg = "查询当前应用可申请的功能列表异常,参数" + buisnessSystemId;
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Transactional
    @Override
    public void auditApply(BusSystemApplyRecord busSystemApplyRecord) throws Exception {
        try {
            if (Constants.AUDIT_RESULT_ERROR.equals(busSystemApplyRecord.getAuditResult())) {
                recordMapper.updateByPrimaryKeySelective(busSystemApplyRecord);
            } else if (Constants.AUDIT_RESULT_OK.equals(busSystemApplyRecord.getAuditResult())) {
                recordMapper.updateByPrimaryKeySelective(busSystemApplyRecord);
                busSystemApplyRecord = busSystemApplyRecordMapper.selectByPrimaryKey(busSystemApplyRecord.getId());
                //生成商户信息
                BusinessPlatform businessPlatform = businessPlatformMapper.selectByPrimaryKey(busSystemApplyRecord.getBusPlatformId());
                SystemPlatform systemPlatform1 = systemPlatformMapper.selectByPrimaryKey(busSystemApplyRecord.getPlatformId());
                BusinessPlatformMerchant businessPlatformMerchant = new BusinessPlatformMerchant();
                businessPlatformMerchant.setPlatformId(busSystemApplyRecord.getPlatformId());
                businessPlatformMerchant.setBusPlatformId(busSystemApplyRecord.getBusPlatformId());
                businessPlatformMerchant.setMerchantName(businessPlatform.getPlatformName());
                businessPlatformMerchant.setMerchantStatus(Constants.MERCHANT_STATUS_NORMAL);
                businessPlatformMerchant.setMerchantNo(Constants.BUS_MER_PREFIX + UUIDUtils.getBusinessNum());
                businessPlatformMerchant.setBusPlatformNo(businessPlatform.getPlatformNo());
                businessPlatformMerchant.setPlatformNo(systemPlatform1.getPlatformNo());
                Date nowDate = new Date();
                businessPlatformMerchant.setUpdateTime(nowDate);
                businessPlatformMerchant.setCreateTime(nowDate);
                businessPlatformMerchant.setCreateUser(busSystemApplyRecord.getAuditUser());
                businessPlatformMerchant.setUpdateUser(busSystemApplyRecord.getAuditUser());
                businessPlatformMerchantMapperCustom.insert(businessPlatformMerchant);

                //生成业务系统密钥对
                SystemPlatform systemPlatform = systemPlatformMapper.selectByPrimaryKey(businessPlatformMerchant.getPlatformId());
                List<BusinessPlateformEncryptWithBLOBs> businessPlateformEncryptWithBLOBsList = new ArrayList<>();
                if (Constants.ENCRYPT_TYPE_RSA.equals(systemPlatform.getEncryptType())) {
                    for (EnvironmentEnum e : EnvironmentEnum.values()) {
                        Map<String, String> keyMap = RSAUtils.genKeyPair(Constants.RSA_KEY_LENGTH);
                        String privateKey = keyMap.get(RSAUtils.PRIVATE_KEY);
                        String publicKey = keyMap.get(RSAUtils.PUBLIC_KEY);
                        BusinessPlateformEncryptWithBLOBs businessPlateformEncryptlist = new BusinessPlateformEncryptWithBLOBs();
                        businessPlateformEncryptlist.setBusMerchantId(businessPlatformMerchant.getId());
                        businessPlateformEncryptlist.setEncryptStatus(Constants.ENCRYPT_STATUS_NORMAL);
                        businessPlateformEncryptlist.setUpdateTime(nowDate);
                        businessPlateformEncryptlist.setCreateTime(nowDate);
                        businessPlateformEncryptlist.setCreateUser(busSystemApplyRecord.getAuditUser());
                        businessPlateformEncryptlist.setUpdateUser(busSystemApplyRecord.getAuditUser());
/*                        businessPlateformEncryptlist.setPrivateKeyContent(privateKey);*/
                        businessPlateformEncryptlist.setPrivateKeyContent(null);
                        businessPlateformEncryptlist.setPrivateKeyUri(iUploadService.uploadPic(privateKey.getBytes(),
                                RSAUtils.PRIVATE_KEY, (long) privateKey.length()));
/*                        businessPlateformEncryptlist.setPublicKeyContent(publicKey);*/
                        businessPlateformEncryptlist.setPublicKeyContent(null);
                        businessPlateformEncryptlist.setPublicKeyUri(iUploadService.uploadPic(publicKey.getBytes(),
                                RSAUtils.PUBLIC_KEY, (long) publicKey.length()));
                        businessPlateformEncryptlist.setEnvFlag(e.getEnvCode());
                        businessPlateformEncryptWithBLOBsList.add(businessPlateformEncryptlist);
                    }
                } else if (Constants.ENCRYPT_TYPE_AES.equals(systemPlatform.getEncryptType())) {
                    SystemEncryptExample systemEncryptExample = new SystemEncryptExample();
                    SystemEncryptExample.Criteria criteria = systemEncryptExample.createCriteria();
                    criteria.andPlatformIdEqualTo(businessPlatformMerchant.getPlatformId());
                    criteria.andEnvFlagEqualTo(systemConfig.getEnvFlag());
                    List<SystemEncryptWithBLOBs> list = systemEncryptMapper.selectByExampleWithBLOBs(systemEncryptExample);
                    BusinessPlateformEncryptWithBLOBs businessPlateformEncryptlist = new BusinessPlateformEncryptWithBLOBs();
                    if (list.size() == 0) {
                        businessPlateformEncryptlist.setPublicKeyContent("");
                    } else {
                        businessPlateformEncryptlist.setPublicKeyContent(list.get(0).getPublicKeyContent());
                    }
                    businessPlateformEncryptWithBLOBsList.add(businessPlateformEncryptlist);
                }
                for (BusinessPlateformEncryptWithBLOBs businessPlateformEncryptWithBLOBs : businessPlateformEncryptWithBLOBsList) {
                    if (businessPlateformEncryptWithBLOBs .getPrivateKeyContent() == null) {
                        businessPlateformEncryptWithBLOBs.setPrivateKeyContent("");
                    }
                    if (businessPlateformEncryptWithBLOBs.getPublicKeyContent() == null) {
                        businessPlateformEncryptWithBLOBs.setPublicKeyContent("");
                    }
                }
                businessPlateformEncryptMapperCustom.insertBatch(businessPlateformEncryptWithBLOBsList);
            } else {
                throw new Exception("AuditResult Error");
            }
        } catch (Exception e) {
            String extraMsg = "审核信息异常，参数:" + busSystemApplyRecord.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }
}
