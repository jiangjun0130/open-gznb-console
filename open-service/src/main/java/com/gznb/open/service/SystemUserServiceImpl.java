package com.gznb.open.service;

import com.gznb.open.common.constants.ExceptionEnum;
import com.gznb.open.common.exception.SystemErrorException;
import com.gznb.open.dao.mybatis.SystemUserMapper;
import com.gznb.open.dao.mybatis.custom.SystemUserMapperCustom;
import com.gznb.open.domain.SystemUser;
import com.gznb.open.domain.SystemUserExample;
import com.gznb.open.domain.custom.BusSystemApplyRecordCustom;
import com.gznb.open.domain.vo.SystemUserVo;
import com.gznb.open.domain.vo.base.PageBean;
import com.gznb.open.service.base.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kl09 on 2017/6/23.
 */
@Service("systemUserService")
public class SystemUserServiceImpl extends AbstractService<SystemUserServiceImpl> implements ISystemUserService {

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Autowired
    private SystemUserMapperCustom systemUserMapperCustom;


    @Transactional
    @Override
    public void insert(List<SystemUser> recordList) throws Exception {
        try {
            systemUserMapperCustom.insertSelective(recordList);
        } catch (Exception e) {
            String extraMsg = "注册用户异常！新增记录：" + recordList.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }

    }

    @Override
    public List<SystemUser> queryByUserName(String userName) throws Exception {
        SystemUserExample systemUserExample = new SystemUserExample();
        systemUserExample.or().andUserNameEqualTo(userName);
        List<SystemUser> systemUsers;
        try {
            systemUsers = systemUserMapper.selectByExample(systemUserExample);
        } catch (Exception e) {
            String extraMsg = "查询用户异常！查询用户名：" + userName;
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
        return systemUsers;
    }

    @Override
    public List<SystemUser> queryRoleByName(String userName) throws Exception {
        if (StringUtils.isEmpty(userName)) {
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    "异常，输入参数为空！", null);
        }
        SystemUserExample systemUserExample = new SystemUserExample();
        systemUserExample.or().andUserNameEqualTo(userName + ".com").andAudioStatusEqualTo(2);
        try {
            return systemUserMapper.selectByExample(systemUserExample);
        } catch (Exception e) {
            String extraMsg = "根据用户名查询用户角色列表错误：" + userName;
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Override
    public PageBean queryUsers(SystemUserVo vo) throws Exception {
        // 查询分页数据
        int startIndex = (vo.getPageBean().getCurrentPage() - 1)
                * vo.getPageBean().getPageSize();
        vo.getPageBean().setStartIndex(startIndex);
        try {
            List<SystemUser> recordList = systemUserMapperCustom.queryUserAndRoleGroupByUsername(vo);
            Integer recordCount = systemUserMapperCustom.getRecordCount(vo);
            return new PageBean(vo.getPageBean().getCurrentPage(), vo.getPageBean().getPageSize(), recordCount, recordList);
        } catch (Exception e) {
            String extraMsg = "根据用户名查询用户角色列表错误：";
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Override
    public void update(SystemUser systemUser) {
        try {
            systemUserMapper.updateByPrimaryKeySelective(systemUser);
        } catch (Exception e) {
            String extraMsg = "修改用户信息异常";
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Override
    public PageBean queryUserAudioList(SystemUserVo vo) {
        // 查询分页数据
        int startIndex = (vo.getPageBean().getCurrentPage() - 1)
                * vo.getPageBean().getPageSize();
        vo.getPageBean().setStartIndex(startIndex);
        try {
            List<SystemUser> recordList = systemUserMapperCustom.queryUserAudioList(vo);
            Integer recordCount = systemUserMapperCustom.queryUserAudioListCount(vo);
            return new PageBean(vo.getPageBean().getCurrentPage(), vo.getPageBean().getPageSize(), recordCount, recordList);
        } catch (Exception e) {
            String extraMsg = "根据用户名查询用户角色列表错误：";
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cancelPermission(SystemUserVo systemUserVo) throws Exception {
        try {

            //查询该用户的所有权限
            List<SystemUser> systemUsers = this.queryByUserName(systemUserVo.getName());
            // 删除该用户信息
            SystemUserExample systemUserExample = new SystemUserExample();
            systemUserExample.or().andUserNameEqualTo(systemUserVo.getName());
            systemUserMapper.deleteByExample(systemUserExample);
            String type = systemUserVo.getType();
            if (StringUtils.isEmpty(type)) {
                return;
            }
            String[] roles = type.split(",");
            SystemUser user = systemUsers.get(0);

            for (String role : roles) {
                // 将页面传入的信息再次插入数据库
                SystemUser systemUser = new SystemUser();
                systemUser.setUserName(systemUserVo.getName());
                systemUser.setMobile(user.getMobile());
                systemUser.setCreateUser(user.getCreateUser());
                systemUser.setRegisterTime(new Date());
                systemUser.setUserType(role);
                systemUser.setAudioStatus(2);
                systemUserMapper.insertSelective(systemUser);
            }
        } catch (Exception e) {
            String extraMsg = "取消用户授权异常：";
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
    }

    public int queryExists(List list, String username) {
        int result = 0;
        try {
            SystemUserExample systemUserExample = new SystemUserExample();
            systemUserExample.or().andUserTypeIn(list).andUserNameEqualTo(username);
            List<SystemUser> resultlist = systemUserMapper.selectByExample(systemUserExample);
            if (resultlist.size() > 0) {
                result = 1;
            } else {
                result = 0;
            }
        } catch (Exception e) {
            String extraMsg = "根据用户名和用户类型查询用户失败：" + username;
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
        return result;
    }

    public List<String> queryTypeByuserName(String userName) throws Exception {

        List<String> list = new ArrayList<>();
        try {
            list = systemUserMapperCustom.queryTypeByuserName(userName);
        } catch (Exception e) {
            String extraMsg = "查询异常：" + e.toString();
            throw new SystemErrorException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION.getExceptionMsg(),
                    extraMsg, e);
        }
        return list;
    }

}
