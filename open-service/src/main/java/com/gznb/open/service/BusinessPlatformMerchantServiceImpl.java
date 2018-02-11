package com.gznb.open.service;

import com.gznb.open.common.config.SystemConfig;
import com.gznb.open.common.constants.Constants;
import com.gznb.open.common.constants.ExceptionEnum;
import com.gznb.open.common.exception.SystemErrorException;
import com.gznb.open.common.utils.RSAUtils;
import com.gznb.open.common.utils.UUIDUtils;
import com.gznb.open.dao.mybatis.*;
import com.gznb.open.dao.mybatis.custom.BusinessPlateformEncryptMapperCustom;
import com.gznb.open.dao.mybatis.custom.BusinessPlatformMerchantMapperCustom;
import com.gznb.open.domain.*;
import com.gznb.open.domain.custom.BusinessPlatformMerchantCustom;
import com.gznb.open.domain.custom.SystemInterfaceCustom;
import com.gznb.open.domain.manual.EnvironmentEnum;
import com.gznb.open.domain.vo.BusinessMerchantVo;
import com.gznb.open.domain.vo.base.PageBean;
import com.gznb.open.service.base.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 商户管理service
 * Created by kl09 on 2017/7/20.
 */
@Service("businessPlatformMerchantService")
public class BusinessPlatformMerchantServiceImpl extends AbstractService<BusinessPlatformMerchantServiceImpl>
        implements IBusinessPlatformMerchantService {

    @Autowired
    private BusinessPlatformMerchantMapper merchantMapper;
    @Autowired
    private BusinessPlatformMerchantMapperCustom merchantMapperCustom;
    @Autowired
    private SystemPlatformMapper systemPlatformMapper;
    @Autowired
    private SystemEncryptMapper systemEncryptMapper;
    @Autowired
    private BusinessPlateformEncryptMapper businessPlateformEncryptMapper;
    @Autowired
    private BusinessPlateformEncryptMapperCustom businessPlateformEncryptMapperCustom;
    @Autowired
    private BusinessPlatformChannelMapper channelMapper;
    @Autowired
    private IUploadService iUploadService;
    @Autowired
    private SystemConfig systemConfig;
    @Autowired
    private IBusinessPlatformEncryptService businessPlatformEncryptService;

    @Override
    public PageBean getPagedData(BusinessMerchantVo vo) throws Exception {
        calculateStartIndex(vo);
        try {
            vo.setEnvFlag(systemConfig.getEnvFlag());
            List<BusinessPlatformMerchantCustom> recordList = merchantMapperCustom.getPagedData(vo);
            for (BusinessPlatformMerchantCustom businessPlatformMerchantCustom : recordList) {
                if (businessPlatformMerchantCustom.getSystemPrivateKeyUriTest() == null) {
                    businessPlatformMerchantCustom.setSystemPrivateKeyUriTest(null);
                } else {
                    businessPlatformMerchantCustom.setSystemPrivateKeyUriTest(systemConfig.getImageUrl() + businessPlatformMerchantCustom.getSystemPrivateKeyUriTest());
                }
                if (businessPlatformMerchantCustom.getSystemPrivateKeyUriPrd() == null) {
                    businessPlatformMerchantCustom.setSystemPrivateKeyUriPrd(null);
                } else {
                    businessPlatformMerchantCustom.setSystemPrivateKeyUriPrd(systemConfig.getImageUrl() + businessPlatformMerchantCustom.getSystemPrivateKeyUriPrd());
                }
                if (businessPlatformMerchantCustom.getBusPublicKeyUriTest() == null) {
                    businessPlatformMerchantCustom.setBusPublicKeyUriTest(null);
                } else {
                    businessPlatformMerchantCustom.setBusPublicKeyUriTest(systemConfig.getImageUrl() + businessPlatformMerchantCustom.getBusPublicKeyUriTest());
                }
                if (businessPlatformMerchantCustom.getBusPublicKeyUriPrd() == null) {
                    businessPlatformMerchantCustom.setBusPublicKeyUriPrd(null);
                } else {
                    businessPlatformMerchantCustom.setBusPublicKeyUriPrd(systemConfig.getImageUrl() + businessPlatformMerchantCustom.getBusPublicKeyUriPrd());
                }
                }
            // 查询分页总数
            Integer recordCount = merchantMapperCustom.getRecordCount(vo);
            return new PageBean(vo.getPageBean().getCurrentPage(), vo.getPageBean().getPageSize(), recordCount, recordList);
        } catch (Exception e) {
            String extraMsg = "查询商户列表信息异常！查询参数：" + vo.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Transactional
    @Override
    public void disableOrEnable(BusinessMerchantVo vo) throws Exception {
        if(StringUtils.isBlank(vo.getId())){
            return;
        }
        // 商户条件
        BusinessPlatformMerchant merchant = new BusinessPlatformMerchant();
        merchant.setId(Integer.valueOf(vo.getId()));
        String status = "";
        if (StringUtils.isEmpty(vo.getMerchantStatus())) {
            return;
        }
        // 对status值进行取反
        status = vo.getMerchantStatus().equals(Constants.SYSTEM_DATA_STATUS_NORMAL) ? Constants.SYSTEM_DATA_STATUS_DISABLE : Constants.SYSTEM_DATA_STATUS_NORMAL;
        merchant.setMerchantStatus(status);
        // 渠道条件
        BusinessPlatformChannelExample example = new BusinessPlatformChannelExample();
        example.or().andBusMerchantIdEqualTo(Integer.valueOf(vo.getId()));
        BusinessPlatformChannelWithBLOBs channel = new BusinessPlatformChannelWithBLOBs();
        channel.setChannelStatus(status);
        try {
            // 禁用商户
            merchantMapper.updateByPrimaryKeySelective(merchant);
            // 禁用渠道
            channelMapper.updateByExampleSelective(channel, example);
        } catch (Exception e) {
            String extraMsg = "禁用商户异常！";
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Transactional
    @Override
    public void delete(BusinessMerchantVo vo) throws Exception {
        if(StringUtils.isBlank(vo.getId())){
            return;
        }
        // 商户条件
        BusinessPlatformMerchant merchant = new BusinessPlatformMerchant();
        merchant.setId(Integer.valueOf(vo.getId()));
        merchant.setMerchantStatus(Constants.MERCHANT_STATUS_DELETED);
        // 渠道条件
        BusinessPlatformChannelExample example = new BusinessPlatformChannelExample();
        example.or().andBusMerchantIdEqualTo(Integer.valueOf(vo.getId()));
        BusinessPlatformChannelWithBLOBs channel = new BusinessPlatformChannelWithBLOBs();
        channel.setChannelStatus(Constants.MERCHANT_STATUS_DELETED);
        try {
            // 删除商户
            merchantMapper.updateByPrimaryKeySelective(merchant);
            // 删除渠道
            channelMapper.updateByExampleSelective(channel, example);
        } catch (Exception e) {
            String extraMsg = "删除商户异常！";
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Transactional
    @Override
    public void update(BusinessPlatformMerchant businessPlatformMerchant) {
        try {
            merchantMapper.updateByPrimaryKeySelective(businessPlatformMerchant);
        } catch (Exception e) {
            String extraMsg = "修改商户状态异常，参数ID:" + businessPlatformMerchant.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }


    @Transactional
    @Override
    public void save(BusinessPlatformMerchant bean) throws Exception {
        if (bean.getId() == null || bean.getId() == 0) {
            // 添加商户
            try {
                //step1 添加商户
                Integer merchantId = this.insert(bean);
                //step2 生成业务系统密钥
                List<BusinessPlateformEncryptWithBLOBs>  businessPlateformEncryptList = new ArrayList<>();
                SystemPlatform systemPlatform = systemPlatformMapper.selectByPrimaryKey(bean.getPlatformId());
                if (Constants.ENCRYPT_TYPE_RSA.equals(systemPlatform.getEncryptType())) {
                    for (EnvironmentEnum e : EnvironmentEnum.values()) {
                        BusinessPlateformEncryptWithBLOBs businessPlateformEncrypt = new BusinessPlateformEncryptWithBLOBs();
                        businessPlateformEncrypt.setBusMerchantId(merchantId);
                        businessPlateformEncrypt.setEncryptStatus(Constants.ENCRYPT_STATUS_NORMAL);
                        businessPlateformEncrypt.setUpdateTime(new Date());
                        businessPlateformEncrypt.setCreateTime(new Date());
                        businessPlateformEncrypt.setCreateUser(bean.getCreateUser());
                        businessPlateformEncrypt.setUpdateUser(bean.getUpdateUser());
                        businessPlateformEncrypt.setEnvFlag(e.getEnvCode());
                        Map<String, String> keyMap = RSAUtils.genKeyPair(Constants.RSA_KEY_LENGTH);
                        String privateKey = keyMap.get(RSAUtils.PRIVATE_KEY);
                        String publicKey = keyMap.get(RSAUtils.PUBLIC_KEY);
                    /*businessPlateformEncrypt.setPrivateKeyContent(privateKey);*/
                        businessPlateformEncrypt.setPrivateKeyContent(null);
                        businessPlateformEncrypt.setPrivateKeyUri(iUploadService.uploadPic(privateKey.getBytes(),
                                RSAUtils.PRIVATE_KEY, (long) privateKey.length()));
                    /*businessPlateformEncrypt.setPublicKeyContent(publicKey);*/
                        businessPlateformEncrypt.setPublicKeyContent(null);
                        businessPlateformEncrypt.setPublicKeyUri(iUploadService.uploadPic(publicKey.getBytes(),
                                RSAUtils.PUBLIC_KEY, (long) publicKey.length()));
                        businessPlateformEncryptList.add(businessPlateformEncrypt);
                    }
                } else if (Constants.ENCRYPT_TYPE_AES.equals(systemPlatform.getEncryptType())) {
                    BusinessPlateformEncryptWithBLOBs businessPlateformEncrypt = new BusinessPlateformEncryptWithBLOBs();
                    SystemEncryptExample systemEncryptExample = new SystemEncryptExample();
                    SystemEncryptExample.Criteria criteria = systemEncryptExample.createCriteria();
                    criteria.andPlatformIdEqualTo(bean.getPlatformId());
                    criteria.andEnvFlagEqualTo(systemConfig.getEnvFlag());
                    List<SystemEncryptWithBLOBs> list = systemEncryptMapper.selectByExampleWithBLOBs(systemEncryptExample);
                    if (list.size() == 0) {
                        businessPlateformEncrypt.setPublicKeyContent("");
                    } else {
                        businessPlateformEncrypt.setPublicKeyContent(list.get(0).getPublicKeyContent());
                    }
                    businessPlateformEncryptList.add(businessPlateformEncrypt);
                }
                businessPlateformEncryptMapperCustom.insertBatch(businessPlateformEncryptList);
            } catch (Exception e) {
                String extraMsg = "添加商户异常，参数:" + bean.toString();
                throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                        ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                        extraMsg, e);
            }
        } else {
            //修改商户
            try {
                merchantMapper.updateByPrimaryKeySelective(bean);
            } catch (Exception e) {
                String extraMsg = "修改商户异常，参数:" + bean.toString();
                throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                        ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                        extraMsg, e);
            }

        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void generateKey(BusinessPlatformMerchant merchant) throws Exception {
        try {
            // step1 将之前该商户的所有所有必要记录状态置为删除
            BusinessPlateformEncrypt record = new BusinessPlateformEncrypt();
            record.setEncryptStatus(Constants.ENCRYPT_STATUS_DELETED);

            BusinessPlateformEncrypt condition = new BusinessPlateformEncrypt();
            condition.setBusMerchantId(merchant.getId());
            condition.setEncryptStatus(Constants.ENCRYPT_STATUS_NORMAL);
            businessPlatformEncryptService.delete(record, condition);

            // step2 根据
            BusinessPlateformEncryptWithBLOBs businessPlateformEncrypt = new BusinessPlateformEncryptWithBLOBs();
            businessPlateformEncrypt.setBusMerchantId(merchant.getId());
            businessPlateformEncrypt.setEncryptStatus(Constants.ENCRYPT_STATUS_NORMAL);
            businessPlateformEncrypt.setUpdateTime(new Date());
            businessPlateformEncrypt.setCreateTime(new Date());
            businessPlateformEncrypt.setCreateUser(merchant.getCreateUser());
            businessPlateformEncrypt.setUpdateUser(merchant.getCreateUser());
            businessPlateformEncrypt.setEnvFlag(systemConfig.getEnvFlag());
            SystemPlatform systemPlatform = systemPlatformMapper.selectByPrimaryKey(merchant.getPlatformId());
            if (Constants.ENCRYPT_TYPE_RSA.equals(systemPlatform.getEncryptType())) {
                Map<String, String> keyMap = RSAUtils.genKeyPair(Constants.RSA_KEY_LENGTH);
                String privateKey = keyMap.get(RSAUtils.PRIVATE_KEY);
                String publicKey = keyMap.get(RSAUtils.PUBLIC_KEY);
/*                businessPlateformEncrypt.setPrivateKeyContent(privateKey);*/
                businessPlateformEncrypt.setPrivateKeyUri(iUploadService.uploadPic(privateKey.getBytes(),
                        RSAUtils.PRIVATE_KEY, (long) privateKey.length()));
/*                businessPlateformEncrypt.setPublicKeyContent(publicKey);*/
                businessPlateformEncrypt.setPublicKeyUri(iUploadService.uploadPic(publicKey.getBytes(),
                        RSAUtils.PUBLIC_KEY, (long) publicKey.length()));
            } else if (Constants.ENCRYPT_TYPE_AES.equals(systemPlatform.getEncryptType())) {
                SystemEncryptExample systemEncryptExample = new SystemEncryptExample();
                SystemEncryptExample.Criteria criteria = systemEncryptExample.createCriteria();
                criteria.andPlatformIdEqualTo(merchant.getPlatformId());
                criteria.andEnvFlagEqualTo(systemConfig.getEnvFlag());
                List<SystemEncryptWithBLOBs> list = systemEncryptMapper.selectByExampleWithBLOBs(systemEncryptExample);
                if (list.size() == 0) {
                    businessPlateformEncrypt.setPublicKeyContent("");
                } else {
                    businessPlateformEncrypt.setPublicKeyContent(list.get(0).getPublicKeyContent());
                }
            }
            businessPlateformEncryptMapper.insert(businessPlateformEncrypt);
        } catch (Exception e) {
            String extraMsg = "生成商户秘钥失败，参数merchant:" + merchant.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Override
    public BusinessPlatformMerchant queryById(Integer id) {
        try {
            return merchantMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            String extraMsg = "查询商户错误，参数id:" + id;
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    /**
     * 添加商户，返回主键
     *
     * @param bean
     * @return
     * @throws Exception
     */
    private Integer insert(BusinessPlatformMerchant bean) throws Exception {
        try {
            Date currentDate = new Date();
            bean.setCreateTime(currentDate);
            bean.setUpdateTime(currentDate);
            //商户编号
            bean.setMerchantNo(Constants.BUS_MER_PREFIX + UUIDUtils.getBusinessNum());

            merchantMapperCustom.insert(bean);
            return bean.getId();
        } catch (Exception e) {
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    "添加商户异常", e);
        }
    }
}
