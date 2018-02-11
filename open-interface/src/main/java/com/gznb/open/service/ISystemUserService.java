package com.gznb.open.service;

import com.gznb.open.domain.SystemUser;
import com.gznb.open.domain.vo.SystemUserVo;
import com.gznb.open.domain.vo.base.PageBean;

import java.util.List;

/**
 * Created by kl09 on 2017/6/23.
 */
public interface ISystemUserService {
    void insert(List<SystemUser> recordList) throws Exception;

    /**
     * 注册的时候根据用户名和用户类型判断是否已存在
     */
    int queryExists(List list, String userName) throws Exception;

    /**
     * 根据用户名查询用户角色，添加到session中并返回给前台
     */
    List<String> queryTypeByuserName(String userNmae) throws Exception;

    /**
     * 根据用户名查询用户，用户名在注册时默认读取单点登录的用户名
     *
     * @param userName 用户名
     * @return 用户集合BY用户名
     */
    List<SystemUser> queryByUserName(String userName) throws Exception;

    /**
     * 根据用户名称查询用户角色
     *
     * @param userName
     * @return
     */
    List<SystemUser> queryRoleByName(String userName) throws Exception;

    /**
     * 查询用户列表,分页
     *
     * @param systemUserVo
     * @return
     * @throws Exception
     */
    PageBean queryUsers(SystemUserVo systemUserVo) throws Exception;

    void update(SystemUser systemUser);

    /**
     * 查询注册用户待审核列表
     *
     * @param systemUserVo
     * @return
     */
    PageBean queryUserAudioList(SystemUserVo systemUserVo);

    void cancelPermission(SystemUserVo systemUserVo) throws Exception;
}
