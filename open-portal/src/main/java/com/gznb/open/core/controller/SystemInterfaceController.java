package com.gznb.open.core.controller;

import com.gznb.open.common.constants.Constants;
import com.gznb.open.core.controller.base.AbstractController;
import com.gznb.open.domain.SystemInterface;
import com.gznb.open.domain.SystemInterfaceWithBLOBs;
import com.gznb.open.domain.custom.SystemInterfaceCustom;
import com.gznb.open.domain.manual.DataCenter;
import com.gznb.open.domain.manual.DataWrap;
import com.gznb.open.domain.vo.SystemInterfaceVo;
import com.gznb.open.domain.vo.base.PageBean;
import com.gznb.open.service.ISystemInterfaceService;
import org.apache.commons.lang3.StringUtils;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统接口
 * <p>
 * Created by jj02 on 2017/6/29.
 */
@RestController
@RequestMapping("/systemInterface")
public class SystemInterfaceController extends AbstractController<SystemInterfaceController> {

    @Autowired
    private ISystemInterfaceService interfaceService;

    @PostMapping(value = "/queryPagedData", produces = "application/json;charset=UTF-8")
    public DataCenter queryPagedData(@RequestBody SystemInterfaceVo vo) throws Exception {
        DataCenter responseData = new DataCenter();
        DataWrap dataWrap = new DataWrap();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        PageBean pageBean = interfaceService.getPagedData(vo);
        // 返回分页数据
        dataWrap.setData(pageBean);
        dataWraps.put("pageBean", dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("查询接口列表成功！");
        return responseData;
    }

    /**
     * 根据接口标识获取接口信息
     * @param interfaceId
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/getDataById/{interfaceId}")
    public  DataCenter getDataById(@PathVariable("interfaceId") Integer interfaceId) throws Exception{
        if(interfaceId == null){
            return new DataCenter(Constants.EXECUTE_ERROR, "输入参数为空");
        }
        DataCenter responseData = new DataCenter();
        DataWrap dataWrap = new DataWrap();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        SystemInterfaceCustom record = interfaceService.getDataById(interfaceId);
        // 返回分页数据
        dataWrap.setData(record);
        dataWraps.put("data", dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("查询响应参数列表成功！");
        return responseData;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/delete/{interfaceId}/{moduleId}")
    public DataCenter delete(@PathVariable(value = "interfaceId") Integer id,
                             @PathVariable(value = "moduleId") Integer moduleId) throws Exception {
        if (id == null) {
            return new DataCenter(Constants.EXECUTE_ERROR, "输入参数为空");
        }
        DataCenter responseData = new DataCenter();
        interfaceService.delete(id);
        SystemInterfaceVo vo = new SystemInterfaceVo();
        vo.setModuleId(moduleId);
        responseData = queryPagedData(vo);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("删除系统接口信息成功！");
        return responseData;
    }

    /**
     * 保存
     *
     * @param vo
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/save", produces = "application/json;charset=UTF-8")
    public DataCenter save(@RequestBody @Valid SystemInterfaceVo vo, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new DataCenter(Constants.EXECUTE_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
        DataCenter responseData = new DataCenter();
        SystemInterfaceWithBLOBs systemInterface = new SystemInterfaceWithBLOBs();
        BeanUtils.copyProperties(vo,systemInterface);
        if(vo.getInterfaceId() == null || vo.getInterfaceId() == 0){
            // insert
            systemInterface.setId(null);
        }else {
            // update
            systemInterface.setId(vo.getInterfaceId());
        }
        systemInterface.setInterfaceName(vo.getName());
        systemInterface.setInterfaceUrl(vo.getPath());
        systemInterface.setRequestMode(vo.getMethod());
        systemInterface.setReqParamWrapperType(vo.getReqWrapperType());
        systemInterface.setRespParamWrapperType(vo.getRespWrapperType());
        systemInterface.setRequestParamFormat(vo.getParamFormat());
        systemInterface.setResponseParamFormat(vo.getResponseFormat());
        systemInterface.setInterfaceStatus(vo.getStatus());
        systemInterface.setInterfaceVersion(vo.getVersion());
        systemInterface.setReqSignRule(vo.getReqRule());
        systemInterface.setReqSignDesc(vo.getReqRuleDesc());
        systemInterface.setRespSignRule(vo.getRespRule());
        systemInterface.setRespSignDesc(vo.getRespRuleDesc());
        SystemInterface record = interfaceService.save(systemInterface);
        // 返回接口id
        DataWrap dataWrap = new DataWrap();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        dataWrap.setData(record.getId());
        dataWraps.put("interfaceId",dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("保存接口信息成功！");
        return responseData;
    }

    /**
     * 根据模块标识查询接口列表信息
     * @param moduleId
     * @return
     * @throws Exception
     */
    @PostMapping("getDataListByModuleId/{moduleId}")
    public DataCenter getDataListByModuleId(@PathVariable("moduleId") Integer moduleId) throws Exception{
        if (moduleId == null) {
            return new DataCenter(Constants.EXECUTE_ERROR, "输入参数为空");
        }
        DataCenter responseData = new DataCenter();
        DataWrap dataWrap = new DataWrap();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        List<SystemInterface> dataList = interfaceService.getDataListByModuleId(moduleId);
        // 返回分页数据
        dataWrap.setData(dataList);
        dataWraps.put("dataList", dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("查询接口列表成功！");
        return responseData;
    }
}
