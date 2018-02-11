package com.gznb.open.core.controller;

import com.gznb.open.common.constants.Constants;
import com.gznb.open.domain.manual.DataCenter;
import com.gznb.open.domain.manual.DataWrap;
import com.gznb.open.domain.vo.BusSystemAccessVo;
import com.gznb.open.domain.vo.base.PageBean;
import com.gznb.open.service.IBusSystemAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 业务系统接入记录
 * Created by kl09 on 2017/6/30.
 */
@RestController
@RequestMapping("/busSystemAccess")
public class BusSysTemAccessController {
    @Autowired
    private IBusSystemAccessService busSystemAccessService;

    @PostMapping(value = "/queryPagedData", produces = "application/json;charset=UTF-8")
    public DataCenter queryPagedData(@RequestBody BusSystemAccessVo vo) throws Exception {
        DataCenter responseData = new DataCenter();
        DataWrap dataWrap = new DataWrap();
        Map<String, DataWrap> dataWraps = new HashMap<>();
        PageBean pageBean = busSystemAccessService.getPagedData(vo);
        // 返回分页数据
        dataWrap.setData(pageBean);
        dataWraps.put("pageBean", dataWrap);
        responseData.setDataWraps(dataWraps);
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("查询接入记录成功！");
        return responseData;
    }
}
