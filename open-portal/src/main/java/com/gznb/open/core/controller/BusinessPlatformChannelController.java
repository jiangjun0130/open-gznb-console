package com.gznb.open.core.controller;

import com.gznb.open.common.constants.Constants;
import com.gznb.open.core.controller.base.AbstractController;
import com.gznb.open.domain.BusinessPlatformChannelWithBLOBs;
import com.gznb.open.domain.custom.BusinessPlatformChannelCustom;
import com.gznb.open.domain.custom.BusinessPlatformMerchantCustom;
import com.gznb.open.domain.manual.DataCenter;
import com.gznb.open.domain.manual.DataWrap;
import com.gznb.open.domain.vo.BusinessChannelVo;
import com.gznb.open.domain.vo.BusinessPlatformChannelVo;
import com.gznb.open.domain.vo.base.PageBean;
import com.gznb.open.service.IBusinessPlatformChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 渠道管理
 * Created by kl09 on 2017/7/12.
 */
@RestController
@RequestMapping("/buschannel")
public class BusinessPlatformChannelController extends AbstractController<BusinessPlatformChannelController> {
    @Autowired
    private IBusinessPlatformChannelService businessPlatformChannelService;

    /**
     * 系统管理列表
     * @param vo
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/queryPagedDataAdmin", produces = "application/json;charset=UTF-8")
    public DataCenter queryPagedDataAdmin(@RequestBody BusinessChannelVo vo) throws Exception {
        DataCenter responseData = new DataCenter();
        DataWrap dataWrap = new DataWrap();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        PageBean pageBean = businessPlatformChannelService.getPagedData(vo);
        // 返回分页数据
        dataWrap.setData(pageBean);
        dataWraps.put("pageBean", dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("查询渠道列表成功！");
        return responseData;
    }

    @PostMapping()
    public DataCenter save(@RequestBody BusinessPlatformChannelWithBLOBs channelWithBLOBs) throws Exception {
        DataCenter<Object> dataCenter = new DataCenter<>();
        businessPlatformChannelService.save(channelWithBLOBs);
        dataCenter.setFlag(Constants.EXECUTE_OK);
        return dataCenter;
    }

    @GetMapping("/one/{id}")
    public DataCenter save(@PathVariable("id") Integer id) throws Exception {
        DataCenter<BusinessPlatformChannelWithBLOBs> dataCenter = new DataCenter<>();
        BusinessPlatformChannelCustom channel = businessPlatformChannelService.queryById(id);
        dataCenter.setFlag(Constants.EXECUTE_OK);
        Map<String, DataWrap> dataWraps = new HashMap<>();
        DataWrap dataWrap = new DataWrap();
        dataWrap.setData(channel);
        dataWraps.put("data", dataWrap);
        dataCenter.setDataWraps(dataWraps);
        return dataCenter;
    }

    @GetMapping("/delete/{id}")
    public DataCenter delete(@PathVariable("id") Integer id) throws Exception {
        DataCenter<BusinessPlatformChannelWithBLOBs> dataCenter = new DataCenter<>();
        businessPlatformChannelService.delete(id);
        dataCenter.setFlag(Constants.EXECUTE_OK);
        dataCenter.setMessage("删除成功");
        return dataCenter;
    }

    @PostMapping(value = "/queryPagedData", produces = "application/json;charset=UTF-8")
    public DataCenter queryPagedData(@RequestBody BusinessPlatformChannelVo vo) throws Exception {
        DataCenter responseData = new DataCenter();
        DataWrap dataWrap = new DataWrap();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        BusinessPlatformMerchantCustom result = businessPlatformChannelService.queryWithChannel(vo);
        // 返回分页数据
        dataWrap.setData(result);
        dataWraps.put("data", dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("查询我的应用列表成功！");
        return responseData;
    }
}
