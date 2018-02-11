package com.gznb.open.service;

import com.gznb.fastdfs.client.FastDFSClient;
import com.gznb.open.common.config.SystemConfig;
import com.gznb.open.common.constants.Constants;
import com.gznb.open.common.constants.ExceptionEnum;
import com.gznb.open.common.exception.SystemErrorException;
import com.gznb.open.common.utils.UUIDUtils;
import com.gznb.open.dao.mybatis.BusinessPlatformChannelMapper;
import com.gznb.open.dao.mybatis.BusinessPlatformMerchantMapper;
import com.gznb.open.dao.mybatis.custom.BusinessPlatformChannelCustomMapper;
import com.gznb.open.domain.BusinessPlatformChannel;
import com.gznb.open.domain.BusinessPlatformChannelExample;
import com.gznb.open.domain.BusinessPlatformChannelWithBLOBs;
import com.gznb.open.domain.BusinessPlatformMerchant;
import com.gznb.open.domain.custom.BusinessPlatformChannelCustom;
import com.gznb.open.domain.custom.BusinessPlatformMerchantCustom;
import com.gznb.open.domain.vo.BusinessChannelVo;
import com.gznb.open.domain.vo.BusinessPlatformChannelVo;
import com.gznb.open.domain.vo.base.PageBean;
import com.gznb.open.service.base.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * 业务系统渠道管理service</n>
 * 请忽略对象命名，实体类名实在有点长.....
 * Created by kl09 on 2017/7/11.
 */
@Service("businessPlatformChannelService")
public class BusinessPlatformChannelServiceImpl extends AbstractService<BusinessPlatformChannelServiceImpl>
        implements IBusinessPlatformChannelService {

    @Autowired
    private BusinessPlatformChannelMapper channelMapper;
    @Autowired
    private BusinessPlatformMerchantMapper merchantMapper;
    @Autowired
    private BusinessPlatformChannelCustomMapper channelCustomMapper;
    @Autowired
    private FastDFSClient fastDFSClient;
    @Autowired
    private SystemConfig systemConfig;

    @Override
    public PageBean getPagedData(BusinessChannelVo vo) throws Exception {
        calculateStartIndex(vo);
        try{
            List<BusinessPlatformChannelCustom> recordList = channelCustomMapper.getPagedData(vo);
            // 查询分页总数
            Integer recordCount = channelCustomMapper.getRecordCount(vo);
            return new PageBean(vo.getPageBean().getCurrentPage(),vo.getPageBean().getPageSize(),recordCount,recordList);
        }catch (Exception e){
            String extraMsg = "查询渠道列表信息异常！查询参数：" + vo.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Transactional
    @Override
    public void save(BusinessPlatformChannelWithBLOBs businessPlatform) throws Exception {
        if (Objects.isNull(businessPlatform)) {
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    "保存渠道信息异常，接收到参数为空");
        }
        Integer channelId = businessPlatform.getId();
        if (StringUtils.isNotBlank(businessPlatform.getCertPath())) {
            String fileUrl = businessPlatform.getCertPath().substring(businessPlatform.getCertPath().indexOf("group"), businessPlatform.getCertPath().length());
            businessPlatform.setCertPath(fileUrl);
        }
        try {
            if (channelId == null || channelId == 0) {
                //添加操作
                if (StringUtils.isBlank(businessPlatform.getBusChannelNo())) {
                    //前台不传入渠道编号，系统生成
                    businessPlatform.setBusChannelNo(Constants.BUS_CHANNEL_PREFIX + UUIDUtils.getBusinessNum());
                }
                channelMapper.insertSelective(businessPlatform);
            } else {
                //修改操作
                channelMapper.updateByPrimaryKeySelective(businessPlatform);
            }
        } catch (Exception e) {
            String extraMsg = "保存渠道失败，参数:" + businessPlatform.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }

    }

    @Transactional
    @Override
    public void delete(Integer channelId) throws Exception {
        if (channelId == null || channelId == 0) {
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    "删除渠道异常，参数为空");
        }
        try {
            BusinessPlatformChannelWithBLOBs channel = new BusinessPlatformChannelWithBLOBs();
            channel.setId(channelId);
            channel.setChannelStatus("3");
            channelMapper.updateByPrimaryKeySelective(channel);
        } catch (Exception e) {
            String extraMsg = "删除渠道异常，参数channelId:" + channelId;
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Override
    public void update(BusinessPlatformChannel businessPlatformChannel) throws Exception {
    }

    @Override
    public List<BusinessPlatformChannelWithBLOBs> query(BusinessPlatformChannelWithBLOBs bpcw)
            throws Exception {
        try {
            BusinessPlatformChannelExample example = new BusinessPlatformChannelExample();
            BusinessPlatformChannelExample.Criteria or = example.or();
            if (StringUtils.isNotBlank(bpcw.getBusChannelName())) {
                or.andBusChannelNameEqualTo(bpcw.getBusChannelName());
            }
            if (bpcw.getId() != null && bpcw.getId() != 0) {
                or.andIdEqualTo(bpcw.getId());
            }

            Optional<BusinessPlatformChannelWithBLOBs> b = Optional.of(bpcw);
            b.map(BusinessPlatformChannelWithBLOBs::getId).ifPresent(or::andIdEqualTo);
            b.map(BusinessPlatformChannelWithBLOBs::getBusMerchantId).ifPresent(or::andBusMerchantIdEqualTo);
            return channelMapper.selectByExampleWithBLOBs(example);
        } catch (Exception e) {
            String extraMsg = "查询渠道异常，查询参数:" + bpcw.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Override
    public BusinessPlatformChannelCustom queryById(Integer id) {
        try {
            BusinessPlatformChannelWithBLOBs businessPlatformChannelWithBLOBs = channelMapper.selectByPrimaryKey(id);
            BusinessPlatformChannelCustom channelCustom = new BusinessPlatformChannelCustom();
            BeanUtils.copyProperties(businessPlatformChannelWithBLOBs,channelCustom);
            Map<String , String > fileURL = fastDFSClient.getFileMetaData(businessPlatformChannelWithBLOBs.getCertPath());
            if (fileURL != null) {
                channelCustom.setCertFileName(fileURL.get("file_name"));
                channelCustom.setCertPath(systemConfig.getImageUrl()+businessPlatformChannelWithBLOBs.getCertPath());
            }
            return channelCustom;
        } catch (Exception e) {
            String extraMsg = "查询渠道异常，查询参数ID:" + id;
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Override
    public BusinessPlatformMerchantCustom queryWithChannel(BusinessPlatformChannelVo vo) {
        //根据商户id查询商户
        BusinessPlatformMerchantCustom result = new BusinessPlatformMerchantCustom();
        BusinessPlatformMerchant merchant = merchantMapper.selectByPrimaryKey(vo.getBusMerchantId());

        // 查询渠道集合
        calculateStartIndex(vo);

        try {
            List<BusinessPlatformChannelWithBLOBs> channels = channelCustomMapper.queryWithPage(vo);
            Integer count = channelCustomMapper.queryWithPageCount(vo);

            PageBean pageBean = new PageBean(vo.getPageBean().getCurrentPage(), vo.getPageBean().getPageSize(), count,
                    channels);
            if (merchant.getMerchantStatus() != "3") {
                result.setBusPlatformId(merchant.getPlatformId());
                result.setCreateTime(merchant.getCreateTime());
                result.setCreateUser(merchant.getCreateUser());
                result.setId(merchant.getId());
                result.setMerchantName(merchant.getMerchantName());
                result.setMerchantNo(merchant.getMerchantNo());
                result.setMerchantStatus(merchant.getMerchantStatus());
                result.setUpdateTime(merchant.getUpdateTime());
                result.setUpdateUser(merchant.getUpdateUser());
                result.setChannels(pageBean);
            }
            return result;
        } catch (Exception e) {
            String extraMsg = "查询业务接入申请记录异常,查询参数" + vo.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }


}
