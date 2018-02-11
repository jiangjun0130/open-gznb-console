package com.gznb.open.core.controller;

import com.gznb.open.common.constants.Constants;
import com.gznb.open.core.controller.base.AbstractController;
import com.gznb.open.domain.SystemPlatformDic;
import com.gznb.open.domain.SystemPlatformDicCatalog;
import com.gznb.open.domain.manual.DataCenter;
import com.gznb.open.domain.manual.DataWrap;
import com.gznb.open.domain.vo.SystemDicVo;
import com.gznb.open.domain.vo.SystemModuleVo;
import com.gznb.open.domain.vo.SystemPlatformDicCatalogVo;
import com.gznb.open.domain.vo.SystemPlatformDicVo;
import com.gznb.open.domain.vo.base.PageBean;
import com.gznb.open.service.ISystemPlatformDicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhenglin on 2017/7/28.
 */
@RestController
@RequestMapping("/systemPlatformDic")
public class SystemPlatformDicController extends AbstractController<SystemPlatformDicController> {

    @Autowired
    private ISystemPlatformDicService iSystemPlatformDicService;

    @PostMapping(value = "/saveDic")
    public DataCenter saveDic(@RequestBody SystemPlatformDicCatalog systemPlatformDicCatalog, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new DataCenter(Constants.EXECUTE_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
        DataCenter responseData = new DataCenter();
        if(systemPlatformDicCatalog.getId() == null || systemPlatformDicCatalog.getId() == 0) {
            // insert
            systemPlatformDicCatalog.setId(null);
        }
        SystemPlatformDicCatalog record = iSystemPlatformDicService.saveDic(systemPlatformDicCatalog);
        // 返回接口id
        DataWrap dataWrap = new DataWrap();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        dataWrap.setData(record.getId());
        dataWraps.put("dicdataId",dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("保存字典信息成功！");
        return responseData;
    }

    /**
     * 保存字典信息
     * @param vo
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @PostMapping("/save")
    public DataCenter save(@RequestBody SystemPlatformDicVo vo, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new DataCenter(Constants.EXECUTE_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
        DataCenter responseData = new DataCenter();
        SystemPlatformDic sample = new SystemPlatformDic();
        if (vo.getDicdataId() == 0 || vo.getDicdataId() == null) {
            sample.setCatalogId(null);
        } else {
            sample.setCatalogId(vo.getDicdataId());
        }
     //   BeanUtils.copyProperties(vo,sample);
        DataWrap dataWrap = new DataWrap();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        for (SystemDicVo samp : vo.getDicList()) {
          sample.setDicName(samp.getDicName());
          sample.setDicValue(samp.getDicValue());
          sample.setDicStatus(samp.getDicStatus());
          sample.setCreateUser(vo.getUserName());
          sample.setUpdateUser(vo.getUserName());
          SystemPlatformDic record = iSystemPlatformDicService.save(sample);
          List dataList = iSystemPlatformDicService.getDicDataBycatalogId(record.getCatalogId());
          dataWrap.setData(dataList);
          dataWraps.put("dataList", dataWrap);
          responseData.setDataWraps(dataWraps);
        }
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("保存数据字典值参数示例成功！");
        return responseData;
    }
    @PostMapping("/getDataBycatalogId/{catalogId}")
    public DataCenter getDataByCatalogId(@PathVariable(value = "catalogId") Integer catalogId) throws Exception {
      if (catalogId == null) {
          return new DataCenter(Constants.EXECUTE_ERROR, "输入参数为空");
      } else {
          DataCenter responseData = new DataCenter();
          DataWrap dataWrap = new DataWrap();
          Map<String, DataWrap> dataWraps = new HashMap<>();
          SystemPlatformDicCatalog record = iSystemPlatformDicService.getDataByCatalogId(catalogId);
          // 返回分页数据
          dataWrap.setData(record);
          dataWraps.put("data", dataWrap);
          responseData.setDataWraps(dataWraps);
          responseData.setFlag(Constants.EXECUTE_OK);
          responseData.setMessage("查询数据字典值列表成功！");
          return responseData;
      }

    }
    @PostMapping("/getDicDataBycatalogId/{platformId}/{catalogId}")
    public DataCenter getDicDataBycatalogId(@PathVariable(value = "catalogId") Integer catalogId) throws Exception {
        if (catalogId == null) {
            return new DataCenter(Constants.EXECUTE_ERROR, "输入参数为空");
        } else {
            DataCenter responseData = new DataCenter();
            DataWrap dataWrap = new DataWrap();
            Map<String, DataWrap> dataWraps = new HashMap<>();
            List dataList = iSystemPlatformDicService.getDicDataBycatalogId(catalogId);
            // 返回分页数据
            dataWrap.setData(dataList);
            dataWraps.put("dataList", dataWrap);
            responseData.setDataWraps(dataWraps);
            responseData.setFlag(Constants.EXECUTE_OK);
            responseData.setMessage("查询数据字典列表成功！");
            return responseData;
        }

    }
    @PostMapping("/update")
    public DataCenter update(@RequestBody SystemDicVo vo, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new DataCenter(Constants.EXECUTE_ERROR, bindingResult.getFieldError().getDefaultMessage());
        } else {
            SystemPlatformDic systemPlatformDic = new SystemPlatformDic();
            systemPlatformDic.setId(vo.getDicdataId());
            systemPlatformDic.setUpdateUser(vo.getUserName());
            BeanUtils.copyProperties(vo,systemPlatformDic);
           DataCenter responseData = new DataCenter();
           iSystemPlatformDicService.updatedic(systemPlatformDic);
           responseData.setFlag(Constants.EXECUTE_OK);
           responseData.setMessage("更新数据字典信息成功！");
           return responseData;
       }
    }
    @PostMapping("/updateCatalog")
    public DataCenter updateCatalog(@RequestBody SystemPlatformDicCatalog systemPlatformDicCatalog, BindingResult bindingResult) throws Exception {
        DataCenter responseData = new DataCenter();
        if (bindingResult.hasErrors()) {
            responseData.setFlag(Constants.EXECUTE_ERROR);
            responseData.setMessage(bindingResult.getFieldError().getDefaultMessage());
        } else if (systemPlatformDicCatalog.getId() == null || systemPlatformDicCatalog.getId() == 0) {
            responseData.setFlag(Constants.EXECUTE_ERROR);
            responseData.setMessage("更新数据字典目录信息失败！");
        } else {
            iSystemPlatformDicService.updateCatalog(systemPlatformDicCatalog);
            responseData.setFlag(Constants.EXECUTE_OK);
            responseData.setMessage("更新数据字典目录信息成功！");
             }
        return responseData;
    }

    @PostMapping("/queryDicData")
    public DataCenter queryDicData(@RequestBody SystemPlatformDicCatalogVo systemPlatformDicCatalog) throws Exception {
        if (systemPlatformDicCatalog.getPlatformId() == null) {
            return new DataCenter(Constants.EXECUTE_ERROR, "输入参数为空");
        } else {
            DataCenter responseData = new DataCenter();
            DataWrap dataWrap = new DataWrap();
            Map<String, DataWrap> dataWraps = new HashMap<>();
            PageBean pageBean = iSystemPlatformDicService.queryDicData(systemPlatformDicCatalog);
            // 返回分页数据
            dataWrap.setData(pageBean);
            dataWraps.put("pageBean", dataWrap);
            responseData.setDataWraps(dataWraps);
            responseData.setFlag(Constants.EXECUTE_OK);
            responseData.setMessage("查询数据字典列表成功！");
            return responseData;
        }

    }

    /**
     * 删除字典信息
     */
    @PostMapping(value = "/deleteDic/{dicId}/{platformId}")
    public DataCenter deleteDic(@PathVariable(value = "dicId") Integer dicId, @PathVariable(value = "platformId") Integer platformId) throws Exception{
        if (dicId == null) {
            return new DataCenter(Constants.EXECUTE_ERROR, "输入参数为空");
        }
        DataCenter responseData = new DataCenter();
        iSystemPlatformDicService.deleteDic(dicId);
        SystemPlatformDicCatalogVo vo = new SystemPlatformDicCatalogVo();
        vo.setPlatformId(platformId);
        responseData = queryDicData(vo);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("删除数据字典信息成功！");
        return responseData;
    }
}
