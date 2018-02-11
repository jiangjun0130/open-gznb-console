package com.gznb.open.core.controller;

import com.gznb.open.common.constants.Constants;
import com.gznb.open.core.controller.base.AbstractController;
import com.gznb.open.domain.BusSystemApplyRecord;
import com.gznb.open.domain.SystemPlatform;
import com.gznb.open.domain.manual.DataCenter;
import com.gznb.open.domain.manual.DataWrap;
import com.gznb.open.domain.vo.BusSystemApplyRecordVo;
import com.gznb.open.domain.vo.base.PageBean;
import com.gznb.open.service.IBusSystemApplyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kl09 on 2017/6/30.
 */
@RestController
@RequestMapping("/busSystemApplyRecord")
public class BusSystemApplyRecordController extends AbstractController<BusSystemApplyRecordController> {
    @Autowired
    private IBusSystemApplyRecordService busSystemApplyRecordService;

    @PostMapping(value = "/queryPagedData", produces = "application/json;charset=UTF-8")
    public DataCenter queryPagedData(@RequestBody BusSystemApplyRecordVo vo) throws Exception {
        DataCenter responseData = new DataCenter();
        DataWrap dataWrap = new DataWrap();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        PageBean pageBean = busSystemApplyRecordService.getPagedData(vo);
        // 返回分页数据
        dataWrap.setData(pageBean);
        dataWraps.put("pageBean", dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("查询我的申请记录列表成功！");
        return responseData;
    }

    @PostMapping(value = "/audit/{id}", produces = "application/json;charset=UTF-8")
    public DataCenter auditData(@PathVariable(value = "id") Integer id, @RequestBody BusSystemApplyRecordVo vo) throws Exception {
        DataCenter responseData = new DataCenter();
        BusSystemApplyRecord record = new BusSystemApplyRecord();
        if (id != null) {
            record.setId(id);
            record.setAuditUser(vo.getAuditUser());
            record.setApplyStatus(Constants.APPLY_STATUS_DOWN + "");
            record.setAuditResult(vo.getAuditResult());
            record.setAuditDescription(vo.getAuditDescription());
            busSystemApplyRecordService.auditApply(record);
        }
        BusSystemApplyRecordVo newVo = new BusSystemApplyRecordVo();
        newVo.setApplyStatus(Constants.APPLY_STATUS_INIT + "");
        newVo.setPlatformManager(vo.getPlatformManager());
        responseData = queryPagedData(newVo);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("审核申请成功！");
        return responseData;
    }

    @GetMapping(value = "/mayApply/{buinessSystemId}", produces = "application/json;charset=UTF-8")
    public DataCenter queryMayApply(@PathVariable("buinessSystemId") Integer buinessSystemId) throws Exception {
        DataCenter responseData = new DataCenter();
        List<SystemPlatform> systemPlatforms = busSystemApplyRecordService.queryMayApply(buinessSystemId);
        DataWrap dataWrap = new DataWrap();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        dataWrap.setDataList(systemPlatforms);
        dataWraps.put("list", dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("查询我的申请记录列表成功！");
        return responseData;
    }

    @PostMapping(value = "/apply", produces = "application/json;charset=UTF-8")
    public DataCenter apply(@RequestBody BusSystemApplyRecordVo vo) throws Exception {
        DataCenter responseData = new DataCenter();
        BusSystemApplyRecord record = new BusSystemApplyRecord();
        if (vo.getBusPlatformId() != null) {
            //申请业务系统ID
            record.setBusPlatformId(vo.getBusPlatformId());
        }
        if (vo.getPlatformId() != null && vo.getPlatformId() != 0) {
            //要申请的平台系统ID
            record.setPlatformId(vo.getPlatformId());
        }
        if (StringUtils.isNotBlank(vo.getApplyUser())) {
            //申请发起人
            record.setApplyUser(vo.getApplyUser());
        }
        if (StringUtils.isNotBlank(vo.getApplyEmail())) {
            //申请人邮箱
            record.setApplyEmail(vo.getApplyEmail());
        }
        if (StringUtils.isNotBlank(vo.getApplyDescription())) {
            //申请备注信息
            record.setApplyDescription(vo.getApplyDescription());
        }
        record.setApplyStatus(String.valueOf(Constants.APPLY_STATUS_INIT));
        busSystemApplyRecordService.save(record);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("申请平台提交成功！");
        return responseData;
    }
}
