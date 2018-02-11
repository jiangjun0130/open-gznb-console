package com.gznb.open.core.controller;

import com.gznb.open.common.constants.Constants;
import com.gznb.open.core.controller.base.AbstractController;
import com.gznb.open.domain.custom.BusinessPlatformEncryptCustom;
import com.gznb.open.domain.custom.SystemEncryptCustom;
import com.gznb.open.domain.manual.DataCenter;
import com.gznb.open.domain.manual.DataWrap;
import com.gznb.open.domain.vo.api.BusPlatformEncryptVo;
import com.gznb.open.domain.vo.api.SysPlatformEncryptVo;
import com.gznb.open.service.IBusinessPlatformEncryptService;
import com.gznb.open.service.IBusinessPlatformMerchantService;
import com.gznb.open.service.ISystemPlatformEncryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * 暴露给各系统的接口
 *
 * @author jiangjun
 * @create 2017/11/7
 */
@RestController
@RequestMapping("/api")
public class ApiController extends AbstractController<ApiController> {

    @Autowired
    private IBusinessPlatformMerchantService merchantService;

    @Autowired
    private IBusinessPlatformEncryptService businessPlatformEncryptService;

    @Autowired
    private ISystemPlatformEncryptService systemPlatformEncryptService;

    /**
     * 获取业务系统公钥信息
     * @param vo
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/getBusPlatformPublicEncrypt",produces = "application/json;charset=UTF-8")
    public DataCenter getBusPlatformPublicEncrypt(@RequestBody @Valid BusPlatformEncryptVo vo, BindingResult bindingResult) throws Exception{
        if (bindingResult.hasErrors()) {
            return new DataCenter(Constants.EXECUTE_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
        DataCenter responseData = new DataCenter();
        DataWrap dataWrap = new DataWrap();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        BusinessPlatformEncryptCustom publicEncrypt = businessPlatformEncryptService.getBusPlatformPublicEncrypt(vo);
        dataWrap.setData(publicEncrypt);
        dataWraps.put("publicEncrypt", dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("查询业务系统公钥信息成功！");
        return responseData;
    }

    /**
     * 查询开放系统密钥信息
     * @param vo
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/getSysPlatformPrivateEncrypt",produces = "application/json;charset=UTF-8")
    public DataCenter getSysPlatformPrivateEncrypt(@RequestBody @Valid SysPlatformEncryptVo vo, BindingResult bindingResult) throws Exception{
        if (bindingResult.hasErrors()) {
            return new DataCenter(Constants.EXECUTE_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
        DataCenter responseData = new DataCenter();
        DataWrap dataWrap = new DataWrap();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        SystemEncryptCustom privateEncrypt = systemPlatformEncryptService.getSysPlatformPrivateEncrypt(vo);
        dataWrap.setData(privateEncrypt);
        dataWraps.put("privateEncrypt", dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("查询开发系统密钥信息成功！");
        return responseData;
    }

}
