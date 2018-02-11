package com.gznb.open.core.controller;

import com.gznb.open.common.constants.Constants;
import com.gznb.open.core.controller.base.AbstractController;
import com.gznb.open.domain.BusinessPlatformChannelWithBLOBs;
import com.gznb.open.domain.BusinessPlatformMerchant;
import com.gznb.open.domain.manual.DataCenter;
import com.gznb.open.domain.manual.DataWrap;
import com.gznb.open.domain.vo.BusinessMerchantVo;
import com.gznb.open.domain.vo.BusinessPlatformVo;
import com.gznb.open.domain.vo.base.PageBean;
import com.gznb.open.service.IBusinessPlatformMerchantService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 商户管理——controller <br/>
 * 1、审核通过后生成商户信息，商户下维护渠道信息<br/>
 * 2、每次申请（业务系统）对应一个商户
 * Created by kl09 on 2017/7/20.
 */
@RestController
@RequestMapping("/merchant")
public class BusinessPlatformMerchantController extends AbstractController<BusinessPlatformMerchantController> {

    @Autowired
    private IBusinessPlatformMerchantService merchantService;

    @PostMapping(value = "/queryPagedData", produces = "application/json;charset=UTF-8")
    public DataCenter queryPagedData(@RequestBody BusinessMerchantVo vo) throws Exception {
        DataCenter responseData = new DataCenter();
        DataWrap dataWrap = new DataWrap();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        PageBean pageBean = merchantService.getPagedData(vo);
        // 返回分页数据
        dataWrap.setData(pageBean);
        dataWraps.put("pageBean", dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("查询商户列表成功！");
        return responseData;
    }

    /**
     * 禁用或重新启用商户
     * @param vo
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/disableOrEnable",produces = "application/json;charset=UTF-8")
    public DataCenter disableOrEnableMerchant(@RequestBody BusinessMerchantVo vo) throws Exception{
        if(StringUtils.isEmpty(vo.getId()) || StringUtils.isEmpty(vo.getMerchantStatus())){
            return new DataCenter(Constants.EXECUTE_ERROR,"输入参数不完整！");
        }
        DataCenter responseData = new DataCenter();
        merchantService.disableOrEnable(vo);
        responseData = queryPagedData(vo);
        return responseData;
    }

    /**
     * 禁用或重新启用商户
     * @param vo
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/delete",produces = "application/json;charset=UTF-8")
    public DataCenter deleteMerchant(@RequestBody BusinessMerchantVo vo) throws Exception{
        if(StringUtils.isEmpty(vo.getId())){
            return new DataCenter(Constants.EXECUTE_ERROR,"输入参数不完整！");
        }
        DataCenter responseData = new DataCenter();
        merchantService.delete(vo);
        responseData = queryPagedData(vo);
        return responseData;
    }

    @PostMapping("/update")
    public DataCenter status(@RequestBody BusinessPlatformMerchant businessPlatformMerchant) throws Exception {
        DataCenter<BusinessPlatformChannelWithBLOBs> dataCenter = new DataCenter<>();
        merchantService.update(businessPlatformMerchant);
        dataCenter.setFlag(Constants.EXECUTE_OK);
        dataCenter.setMessage("修改成功");
        return dataCenter;
    }

    @PostMapping(value = "/save", produces = "application/json;charset=UTF-8")
    public DataCenter save(@RequestBody BusinessPlatformMerchant bean) throws Exception {
        DataCenter responseData = new DataCenter();
        HashMap<String, DataWrap> dataWraps = new HashMap<>();
        merchantService.save(bean);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("新增商户成功！");
        return responseData;
    }

    @GetMapping("/byId/{id}")
    public DataCenter getOne(@PathVariable("id") Integer id) {
        BusinessPlatformMerchant merchant = merchantService.queryById(id);
        DataCenter responseData = new DataCenter();
        HashMap<String, DataWrap> dataWraps = new HashMap<>();
        DataWrap<Object> dataWrap = new DataWrap<>();
        dataWrap.setData(merchant);
        dataWraps.put("data", dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("查询商户成功！");
        return responseData;
    }

    @PostMapping("/generate}")
    public DataCenter generateKey(@RequestBody BusinessPlatformMerchant merchant) throws Exception {
        DataCenter responseData = new DataCenter();
        HashMap<String, DataWrap> dataWraps = new HashMap<>();
        merchantService.generateKey(merchant);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("生成商户秘钥信息成功！");
        return responseData;
    }

}
