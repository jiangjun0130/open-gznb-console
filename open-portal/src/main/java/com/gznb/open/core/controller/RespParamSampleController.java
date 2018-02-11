package com.gznb.open.core.controller;

import com.gznb.open.common.constants.Constants;
import com.gznb.open.core.controller.base.AbstractController;
import com.gznb.open.domain.InterfaceRespParamSample;
import com.gznb.open.domain.manual.DataCenter;
import com.gznb.open.domain.manual.DataWrap;
import com.gznb.open.domain.vo.ReqParamSampleVo;
import com.gznb.open.service.IRespParamSampleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jj02 on 2017/7/7.
 */
@RestController
@RequestMapping("/respParamSample")
public class RespParamSampleController extends AbstractController<RespParamSampleController> {

    @Autowired
    private IRespParamSampleService respParamSampleService;

    @PostMapping(value = "/getDataByInterfaceId/{interfaceId}")
    public DataCenter getDataByInterfaceId(@PathVariable("interfaceId") Integer interfaceId) throws Exception{
        if(interfaceId == null || interfaceId == 0) {
            return new DataCenter(Constants.EXECUTE_ERROR, "输入参数为空");
        }
        DataCenter responseData = new DataCenter();
        DataWrap dataWrap = new DataWrap();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        InterfaceRespParamSample record = respParamSampleService.getDataByInterfaceId(interfaceId);
        // 返回分页数据
        dataWrap.setData(record);
        dataWraps.put("data", dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("查询接口响应参数示例成功！");
        return responseData;
    }

    /**
     * 保存
     * @param vo
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/save", produces = "application/json;charset=UTF-8")
    public DataCenter save(@RequestBody @Valid ReqParamSampleVo vo, BindingResult bindingResult) throws Exception{
        if (bindingResult.hasErrors()) {
            return new DataCenter(Constants.EXECUTE_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
        DataCenter responseData = new DataCenter();
        InterfaceRespParamSample sample = new InterfaceRespParamSample();
        BeanUtils.copyProperties(vo,sample);
        if(vo.getSampleId() == 0 || vo.getSampleId() == null){
            sample.setId(null);
        }else {
            sample.setId(vo.getSampleId());
        }
        sample.setResponseSample(vo.getSampleContent());
        if(StringUtils.isNotBlank(vo.getSampleUrl())){
            String imageUrl=vo.getSampleUrl().substring(vo.getSampleUrl().indexOf("group"), vo.getSampleUrl().length());
            sample.setSampleUri(imageUrl);
        }
        InterfaceRespParamSample record = respParamSampleService.save(sample);
        DataWrap dataWrap = new DataWrap();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        dataWrap.setData(record.getId());
        dataWraps.put("sampleId",dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("保存接口响应参数示例成功！");
        return responseData;
    }

}
