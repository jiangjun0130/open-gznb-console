package com.gznb.open.core.controller;

import com.gznb.open.common.constants.Constants;
import com.gznb.open.core.controller.base.AbstractController;
import com.gznb.open.domain.SystemUser;
import com.gznb.open.domain.manual.DataCenter;
import com.gznb.open.domain.manual.DataWrap;
import com.gznb.open.domain.vo.SystemUserVo;
import com.gznb.open.domain.vo.base.PageBean;
import com.gznb.open.service.ISystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kl09 on 2017/6/23.
 */
@RestController
@RequestMapping("/systemuser")
public class SystemUserController extends AbstractController<SystemUserController> {

    @Autowired
    private ISystemUserService systemUserService;

    @PostMapping("/register")
    public DataCenter insert(@RequestBody @Valid SystemUserVo vo, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new DataCenter(Constants.EXECUTE_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
        DataCenter<Object> dataCenter = new DataCenter<>();
        String[] split = vo.getType().trim().split(",");
        List<SystemUser> listsystemuser = new ArrayList();
        List listtype = new ArrayList();
        for (String type : split) {
            SystemUser newUser = new SystemUser();
            newUser.setUserName(vo.getName());
            newUser.setMobile(vo.getMobile());
            newUser.setUserType(type);
            newUser.setNote(vo.getNote());
            listsystemuser.add(newUser);
            listtype.add(type);
        }
        int result = 0;
        result = systemUserService.queryExists(listtype, vo.getName());
        if (result == 1) {
            dataCenter.setFlag(Constants.EXECUTE_ERROR);
            return dataCenter;
        } else {
            systemUserService.insert(listsystemuser);
            dataCenter.setFlag(Constants.EXECUTE_OK);
            return dataCenter;
        }

    }

    @GetMapping("/role/{userName}")
    public DataCenter queryRoleByName(@PathVariable("userName") String userName) throws Exception {
        DataCenter<Object> dataCenter = new DataCenter<>();
        List<SystemUser> list = systemUserService.queryRoleByName(userName);
        dataCenter.setFlag((Constants.EXECUTE_OK));
        HashMap<String, DataWrap> data = new HashMap<>();
        DataWrap<SystemUser> dataWrap = new DataWrap<>();
        dataWrap.setDataList(list);
        data.put("data", dataWrap);
        dataCenter.setDataWraps(data);
        return dataCenter;
    }

    @PostMapping("/users")
    public DataCenter queryUserList(@RequestBody SystemUserVo systemUserVo) throws Exception {
        DataCenter<Object> dataCenter = new DataCenter<>();
        PageBean pageBean = systemUserService.queryUsers(systemUserVo);
        HashMap<String, DataWrap> data = new HashMap<>();
        DataWrap<PageBean> dataWrap = new DataWrap<>();
        dataWrap.setData(pageBean);
        data.put("pageBean", dataWrap);
        dataCenter.setFlag((Constants.EXECUTE_OK));
        dataCenter.setDataWraps(data);
        return dataCenter;
    }

    @PostMapping("/users/audio")
    public DataCenter queryUserAudioList(@RequestBody SystemUserVo systemUserVo) throws Exception {
        DataCenter<Object> dataCenter = new DataCenter<>();
        PageBean pageBean = systemUserService.queryUserAudioList(systemUserVo);
        HashMap<String, DataWrap> data = new HashMap<>();
        DataWrap<PageBean> dataWrap = new DataWrap<>();
        dataWrap.setData(pageBean);
        data.put("pageBean", dataWrap);
        dataCenter.setFlag((Constants.EXECUTE_OK));
        dataCenter.setDataWraps(data);
        return dataCenter;
    }

    @PostMapping("/users/permission")
    public DataCenter permissionManager(@RequestBody SystemUserVo systemUserVo) throws Exception {
        DataCenter<Object> dataCenter = new DataCenter<>();
        systemUserService.cancelPermission(systemUserVo);
        dataCenter.setFlag((Constants.EXECUTE_OK));
        return dataCenter;
    }
    @PostMapping("/update")
    public DataCenter update(@RequestBody SystemUser systemUser) throws Exception {
        DataCenter<Object> dataCenter = new DataCenter<>();
        systemUserService.update(systemUser);
        dataCenter.setFlag((Constants.EXECUTE_OK));
        return dataCenter;
    }
}
