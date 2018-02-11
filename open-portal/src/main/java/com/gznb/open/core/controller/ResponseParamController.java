package com.gznb.open.core.controller;

import com.gznb.open.common.constants.Constants;
import com.gznb.open.core.controller.base.AbstractController;
import com.gznb.open.domain.InterfaceResponseParams;
import com.gznb.open.domain.manual.DataCenter;
import com.gznb.open.domain.manual.DataWrap;
import com.gznb.open.domain.vo.ResponseParamVo;
import com.gznb.open.service.IRespParamService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jj02 on 2017/7/5.
 */
@RestController
@RequestMapping("responseParam")
public class ResponseParamController extends AbstractController<ResponseParamController> {

    @Autowired
    private IRespParamService respParamService;

    /**
     * 根据接口标识获取请求参数列表
     *
     * @param interfaceId
     * @return
     * @throws Exception
     */
    @PostMapping(value = "getDataListById/{platformId}/{interfaceId}/{moduleId}")
    public DataCenter getDataListById(@PathVariable("platformId") Integer platformId,
                                      @PathVariable("interfaceId") Integer interfaceId,
                                      @PathVariable("moduleId") Integer moduleId) throws Exception {
        if (interfaceId == null || platformId == null) {
            return new DataCenter(Constants.EXECUTE_ERROR, "输入参数为空");
        }
        DataCenter responseData = new DataCenter();
        DataWrap dataWrap = new DataWrap();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        List dataList = respParamService.getDataListById(platformId, interfaceId, moduleId);
        // 返回分页数据
        dataWrap.setData(dataList);
        dataWraps.put("dataList", dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("查询响应参数列表成功！");
        return responseData;
    }

    @RequestMapping(value = "/save", produces = "application/json;charset=UTF-8")
    public DataCenter save(@RequestBody @Valid ResponseParamVo vo, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new DataCenter(Constants.EXECUTE_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
        DataCenter responseData = new DataCenter();
        InterfaceResponseParams param = new InterfaceResponseParams();
        if (StringUtils.isNotBlank(vo.getId()) && !vo.getId().equals("0")) {
            // update
            param.setId(Integer.valueOf(vo.getId()));
            param.setUpdateTime(new Date());
        } else {
            // insert
            param.setId(null);
        }
        BeanUtils.copyProperties(vo, param);
        param.setParamName(vo.getName());
        param.setParamNameCn(vo.getNameCn());
        param.setParamType(vo.getType());
        param.setParamTree(vo.getTreeType());
        param.setParamStatus(vo.getStatus());
        respParamService.save(param);
        responseData = getDataListById(vo.getPlatformId(), vo.getInterfaceId(), vo.getModuleId());
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("更新响应参数成功！");
        return responseData;
    }

    /**
     * 删除
     *
     * @param interfaceId
     * @return
     */
    @PostMapping(value = "/delete/{platformId}/{interfaceId}/{respParamId}/{moduleId}")
    public DataCenter delete(@PathVariable(value = "platformId") Integer platformId,
                             @PathVariable(value = "interfaceId") Integer interfaceId,
                             @PathVariable(value = "respParamId") Integer respParamId,
                             @PathVariable(value = "moduleId") Integer moduleId) throws Exception {
        if (interfaceId == null || respParamId == null) {
            return new DataCenter(Constants.EXECUTE_ERROR, "输入参数为空");
        }
        DataCenter responseData = new DataCenter();
        respParamService.delete(respParamId);
        responseData = getDataListById(platformId, interfaceId, moduleId);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("删除响应参数成功！");
        return responseData;
    }
}
