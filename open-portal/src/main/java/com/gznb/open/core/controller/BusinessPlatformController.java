package com.gznb.open.core.controller;

import com.gznb.open.common.constants.Constants;
import com.gznb.open.common.utils.UUIDUtils;
import com.gznb.open.core.controller.base.AbstractController;
import com.gznb.open.domain.BusSystemApplyRecord;
import com.gznb.open.domain.BusinessPlatform;
import com.gznb.open.domain.custom.BusinessPlatformCustom;
import com.gznb.open.domain.manual.DataCenter;
import com.gznb.open.domain.manual.DataWrap;
import com.gznb.open.domain.vo.BusinessPlatformVo;
import com.gznb.open.domain.vo.base.PageBean;
import com.gznb.open.service.IBusSystemApplyRecordService;
import com.gznb.open.service.IBusinessPlatformService;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * “我的应用”——业务系统
 * Created by kl09 on 2017/6/30.
 */
@RestController
@RequestMapping("/businessPlatform")
public class BusinessPlatformController extends AbstractController<BusinessPlatformController> {

    @Autowired
    private IBusinessPlatformService businessPlatformService;
    @Autowired
    private IBusSystemApplyRecordService busSystemApplyRecordService;

    @PostMapping(value = "/queryPagedData", produces = "application/json;charset=UTF-8")
    public DataCenter queryPagedData(@RequestBody BusinessPlatformVo vo) throws Exception {
        DataCenter responseData = new DataCenter();
        DataWrap dataWrap = new DataWrap();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        PageBean pageBean = businessPlatformService.getPagedData(vo);
        // 返回分页数据
        dataWrap.setData(pageBean);
        dataWraps.put("pageBean", dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("查询我的应用列表成功！");
        return responseData;
    }

    @PostMapping(value = "/queryPagedDataWithApply", produces = "application/json;charset=UTF-8")
    public DataCenter queryPagedDataWithApply(@RequestBody BusinessPlatformVo vo) throws Exception {
        DataCenter responseData = new DataCenter();
        DataWrap dataWrap = new DataWrap();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        PageBean pageBean = businessPlatformService.getPageDataWithApply(vo);
        dataWrap.setData(pageBean);
        dataWraps.put("pageBean", dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("查询我的应用列表成功！");
        return responseData;
    }

    @GetMapping("/queryWhitChannel/{id}")
    public DataCenter queryWhitChannel(@PathVariable("id") Integer id) {
        DataCenter responseData = new DataCenter();
        DataWrap<BusinessPlatformCustom> dataWrap = new DataWrap();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        BusinessPlatformCustom businessPlatformCustom = businessPlatformService.queryWithChannel(id);
        dataWrap.setData(businessPlatformCustom);
        responseData.setFlag(Constants.EXECUTE_OK);
        dataWraps.put("data", dataWrap);
        responseData.setDataWraps(dataWraps);
        return responseData;
    }

    @PostMapping(value = "/save", produces = "application/json;charset=UTF-8")
    public DataCenter save(@RequestBody BusinessPlatformVo vo) throws Exception {
        DataCenter responseData = new DataCenter();
        BusinessPlatform bp = new BusinessPlatform();
        if (StringUtils.isNotBlank(vo.getPlatformName())) {
            bp.setPlatformName(vo.getPlatformName());
        }
        if (StringUtils.isNotBlank(vo.getNote())) {
            bp.setNote(vo.getNote());
        }
        bp.setCreateUser(vo.getCreateUser());
        bp.setCreateTime(new Date());
        bp.setPlatformNo(Constants.BUS_PLATFORM_PREFIX + UUIDUtils.getBusinessNum()); // 设置业务系统编号
        bp.setPlatformStatus(Constants.BUSSYSTEM_STATUS_NORMAL);
        Integer insert = businessPlatformService.insert(bp, vo);
        HashMap<String, Object> dataWrap = new HashMap<>();
            dataWrap.put("businessPlateFormId", insert);
        responseData.setDataWraps(dataWrap);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("查询我的应用列表成功！");
        return responseData;
    }

}
