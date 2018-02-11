package com.gznb.open.core.controller;

import com.gznb.open.common.constants.Constants;
import com.gznb.open.core.controller.base.AbstractController;
import com.gznb.open.domain.SystemInterface;
import com.gznb.open.domain.SystemModule;
import com.gznb.open.domain.custom.SystemModuleCustom;
import com.gznb.open.domain.manual.DataCenter;
import com.gznb.open.domain.manual.DataWrap;
import com.gznb.open.domain.vo.SystemModuleVo;
import com.gznb.open.domain.vo.base.PageBean;
import com.gznb.open.service.ISystemInterfaceService;
import com.gznb.open.service.ISystemModuleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统模块
 * <p>
 * Created by jj02 on 2017/6/28.
 */
@RestController
@RequestMapping("/systemModule")
public class SystemModuleController extends AbstractController<SystemModuleController> {

    @Autowired
    private ISystemModuleService systemModuleService;

    @Autowired
    private ISystemInterfaceService interfaceService;

    @PostMapping(value = "/queryPagedData", produces = "application/json;charset=UTF-8")
    public DataCenter queryPagedData(@RequestBody SystemModuleVo vo) throws Exception {
        DataCenter responseData = new DataCenter();
        DataWrap dataWrap = new DataWrap();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        PageBean pageBean = systemModuleService.getPagedData(vo);
        // 返回分页数据
        dataWrap.setData(pageBean);
        dataWraps.put("pageBean", dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("查询模块列表成功！");
        return responseData;
    }

    /**
     * 删除
     *
     * @param moduleId
     * @return
     */
    @PostMapping(value = "/delete/{moduleId}/{platformId}")
    public DataCenter delete(@PathVariable(value = "moduleId") Integer moduleId,
                             @PathVariable(value = "platformId") Integer platformId) throws Exception {
        if (moduleId == null) {
            return new DataCenter(Constants.EXECUTE_ERROR, "输入参数为空");
        }
        DataCenter responseData = new DataCenter();
        systemModuleService.delete(moduleId);
        SystemModuleVo vo = new SystemModuleVo();
        vo.setPlatformId(platformId);
        responseData = queryPagedData(vo);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("删除系统模块信息成功！");
        return responseData;
    }

    /**
     * 保存
     *
     * @param vo
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "save", produces = "application/json;charset=UTF-8")
    public DataCenter save(@RequestBody @Valid SystemModuleVo vo, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new DataCenter(Constants.EXECUTE_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
        DataCenter responseData = new DataCenter();
        SystemModule module = new SystemModule();
        BeanUtils.copyProperties(vo, module);
        if (vo.getModuleId() != null) {
            // update
            module.setId(vo.getModuleId());
            if (StringUtils.isNotBlank(vo.getStatus())) {
                module.setModuleStatus(vo.getStatus());
            }
        } else {
            // insert
            module.setModuleStatus(Constants.SYSTEM_DATA_STATUS_NORMAL);
        }
        if (StringUtils.isNotBlank(vo.getName())) {
            module.setModuleName(vo.getName());
        }
        if (StringUtils.isNotBlank(vo.getPath())) {
            module.setModuleUrl(vo.getPath());
        } else {
            module.setModuleUrl("");
        }
        systemModuleService.save(module);
        vo.setName("");
        responseData = queryPagedData(vo);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("更新系统模块信息成功！");
        return responseData;
    }

    /**
     * 根据系统id查询模块信息
     *
     * @param platformId
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/queryDataByPlatformId/{platformId}")
    public DataCenter queryDataByPlatformId(@PathVariable("platformId") Integer platformId) throws Exception {
        if (platformId == null) {
            return new DataCenter(Constants.EXECUTE_ERROR, "输入参数为空！");
        }
        DataCenter responseData = new DataCenter();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        DataWrap dataWrap = new DataWrap();
        List<SystemModule> list = systemModuleService.queryDataByPlatformId(platformId);
        dataWrap.setData(list);
        dataWraps.put("dataList", dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("查询模块信息成功！");
        return responseData;
    }

    /**
     * 根据系统id查询模块信息
     *
     * @param platformId
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/queryModuleAndInterfaceListByPlatformId/{platformId}")
    public DataCenter queryModuleAndInterfaceListByPlatformId(@PathVariable("platformId") Integer platformId) throws Exception {
        if (platformId == null) {
            return new DataCenter(Constants.EXECUTE_ERROR, "输入参数为空！");
        }
        DataCenter responseData = new DataCenter();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        DataWrap dataWrap = new DataWrap();
        List<SystemModuleCustom> list = systemModuleService.queryModuleAndInterfaceListByPlatformId(platformId);
        dataWrap.setData(list);
        dataWraps.put("dataList", dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("查询模块及接口列表信息成功！");
        return responseData;
    }
}
