package com.gznb.open.core.controller;

import com.gznb.open.common.constants.Constants;
import com.gznb.open.common.utils.UUIDUtils;
import com.gznb.open.core.controller.base.AbstractController;
import com.gznb.open.domain.SystemPlatform;
import com.gznb.open.domain.custom.SystemPlatformDicCatalogCustom;
import com.gznb.open.domain.manual.DataCenter;
import com.gznb.open.domain.manual.DataWrap;
import com.gznb.open.domain.vo.SystemModuleVo;
import com.gznb.open.domain.vo.SystemPlatformVo;
import com.gznb.open.domain.vo.base.PageBean;
import com.gznb.open.service.ISystemPlatformService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jj02 on 2017/6/20.
 */
@RestController
@RequestMapping("/systemPlatform")
public class SystemPlatformController extends AbstractController<SystemPlatformController> {

    @Autowired
    private ISystemPlatformService systemPlatformService;

    @PostMapping(value = "/queryPagedData", produces = "application/json;charset=UTF-8")
    public DataCenter queryPagedData(@RequestBody SystemPlatformVo vo) throws Exception {
        DataCenter responseData = new DataCenter();
        DataWrap dataWrap = new DataWrap();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        PageBean pageBean = systemPlatformService.getPagedData(vo);
        // 返回分页数据
        dataWrap.setData(pageBean);
        dataWraps.put("pageBean", dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("查询平台列表成功！");
        return responseData;
    }

    /**
     * 保存
     *
     * @param vo
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/save", produces = "application/json;charset=UTF-8")
    public DataCenter save(@RequestBody @Valid SystemPlatformVo vo, BindingResult bindingResult) throws Exception {
         if (bindingResult.hasErrors()) {
            return new DataCenter(Constants.EXECUTE_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
        DataCenter responseData = new DataCenter();
        SystemPlatform platform = new SystemPlatform();
        BeanUtils.copyProperties(vo, platform);
        if (vo.getPlatformId() != null) {
            // update
            platform.setId(vo.getPlatformId());
            platform.setPlatformStatus(vo.getStatus());
            if(StringUtils.isBlank(vo.getPlatformNo())){
                platform.setPlatformNo(Constants.SYSTEM_PLATFORM_PREFIX + UUIDUtils.getBusinessNum());
            }
        } else {
            // insert
            platform.setPlatformNo(Constants.SYSTEM_PLATFORM_PREFIX + UUIDUtils.getBusinessNum());
            platform.setPlatformStatus(Constants.SYSTEM_DATA_STATUS_NORMAL);
        }
        if (StringUtils.isNotBlank(vo.getTestEnvUrl())) {
            platform.setTestUrl(vo.getTestEnvUrl());
        } else {
            platform.setTestUrl("");
        }
        if (StringUtils.isNotBlank(vo.getPreEnvUrl())) {
            platform.setPreUrl(vo.getPreEnvUrl());
        } else {
            platform.setPreUrl("");
        }
        if (StringUtils.isNotBlank(vo.getPrdEnvUrl())) {
                platform.setPrdUrl(vo.getPrdEnvUrl());
        } else {
            platform.setPrdUrl("");
        }
        if (StringUtils.isNotBlank(vo.getImageUrl())) {
            String imageUrl=vo.getImageUrl().substring(vo.getImageUrl().indexOf("group"), vo.getImageUrl().length());
            platform.setPlatformImage(imageUrl);
        }
        systemPlatformService.update(platform);
        SystemPlatformVo newVo = new SystemPlatformVo();
        newVo.setPageBean(vo.getPageBean());
        //responseData = queryPagedData(newVo);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("更新系统平台信息成功！");
        return responseData;
    }

    /**
     * 删除
     *
     * @param vo
     * @return
     */
    @PostMapping(value = "/delete",produces = "application/json;charset=UTF-8")
    public DataCenter delete(@RequestBody SystemPlatformVo vo) throws Exception {
        if (vo.getPlatformId() == null) {
            return new DataCenter(Constants.EXECUTE_ERROR, "输入参数为空");
        }
        DataCenter responseData = new DataCenter();
        systemPlatformService.delete(vo.getPlatformId());
        SystemPlatformVo newVo = new SystemPlatformVo();
        newVo.setPageBean(vo.getPageBean());
        //responseData = queryPagedData(newVo);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("删除系统平台信息成功！");
        return responseData;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/getDataById/{id}")
    public DataCenter getDataById(@PathVariable(value = "id") Integer id) throws Exception {
        if (id == null) {
            return new DataCenter(Constants.EXECUTE_ERROR, "输入参数为空");
        }
        DataCenter responseData = new DataCenter();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        SystemPlatform platform = systemPlatformService.getDataById(id);
        if (platform != null) {
            DataWrap dataWrap = new DataWrap();
            dataWrap.setData(platform);
            dataWraps.put("platform", dataWrap);
            responseData.setDataWraps(dataWraps);
        }
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("查询系统平台信息成功！");
        return responseData;
    }

    /**
     * 查询平台数据字典
     */
    @PostMapping(value = "queryData")
    public DataCenter getDictionaryData(@RequestBody SystemModuleVo vo) throws Exception {
        DataCenter dataCenter = new DataCenter();
        Map<String, DataWrap> dataWraps = new HashMap<>();
/*        PageBean pageBean = systemPlatformService.getDatadictionaryById(vo);*/
        List<SystemPlatformDicCatalogCustom>  recordList = systemPlatformService.getDatadictionaryById(vo);

        if (recordList != null) {
            DataWrap dataWrap = new DataWrap();
            // 返回分页数据
            dataWrap.setData(recordList);
            dataWraps.put("recordList", dataWrap);
            dataCenter.setDataWraps(dataWraps);
        }
        dataCenter.setFlag(Constants.EXECUTE_OK);
        dataCenter.setMessage("查询平台数据字典成功");
        return dataCenter;

    }
}
