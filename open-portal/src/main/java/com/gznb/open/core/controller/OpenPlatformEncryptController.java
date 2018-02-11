package com.gznb.open.core.controller;

import com.gznb.open.common.constants.Constants;
import com.gznb.open.domain.OpenPlatformEncrypt;
import com.gznb.open.domain.manual.DataCenter;
import com.gznb.open.domain.manual.DataWrap;
import com.gznb.open.service.IOpenPlatformEncryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/encrypt")
public class OpenPlatformEncryptController {

    @Autowired
    private IOpenPlatformEncryptService openPlatformEncryptService;

    @GetMapping(value = "/generate", produces = "application/json;charset=UTF-8")
    public DataCenter generateKey() throws Exception {
        DataCenter responseData = new DataCenter();
        openPlatformEncryptService.generateKey();
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("生成秘钥信息成功！");
        return responseData;
    }

    @GetMapping()
    public DataCenter queryKey() throws Exception {
        DataCenter responseData = new DataCenter();
        DataWrap dataWrap = new DataWrap();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        Map<String, List<OpenPlatformEncrypt>> query = openPlatformEncryptService.query();
        dataWrap.setData(query);
        dataWraps.put("encrypts", dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("查询秘钥信息成功！");
        return responseData;
    }

}
