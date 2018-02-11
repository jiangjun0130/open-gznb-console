package com.gznb.open.core.controller;

import com.gznb.open.domain.SystemPlatform;
import com.gznb.open.domain.manual.DataCenter;
import com.gznb.open.domain.vo.SystemPlatformVo;
import com.gznb.open.common.constants.Constants;
import com.gznb.open.core.controller.base.AbstractController;
import com.gznb.open.service.ISystemPlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by jj02 on 2017/6/15.
 */
@RestController
@RequestMapping("/test")
public class TestController extends AbstractController<TestController> {

    @Autowired
    private ISystemPlatformService platformService;

    @PostMapping(value = "/insert",produces = "application/json;charset=UTF-8")
    public DataCenter insert(@RequestBody @Valid SystemPlatformVo plateformVo, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new DataCenter(Constants.EXECUTE_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
        DataCenter responseData = new DataCenter();
        SystemPlatform plateform = new SystemPlatform();
        plateform.setId(plateformVo.getPlatformId());
        plateform.setPlatformName(plateformVo.getPlatformName());
        plateform.setDescription(plateformVo.getDescription());
        plateform.setEncryptType(plateformVo.getEncryptType());
        plateform.setPlatformStatus(Constants.SYSTEM_DATA_STATUS_NORMAL);
        platformService.update(plateform);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("新增系统平台成功！");
        return responseData;
    }

}
