package com.gznb.open.dao.mybatis.custom;

import com.gznb.open.domain.SystemUser;
import com.gznb.open.domain.vo.SystemUserVo;

import java.util.List;

/**
 * Created by zhenglin on 2017/7/17.
 */
public interface SystemUserMapperCustom {
    int insertSelective(List<SystemUser> recordList);

    List<String> queryTypeByuserName(String userName);

    List<SystemUser> queryUserAndRoleGroupByUsername(SystemUserVo systemUserVo);

    Integer getRecordCount(SystemUserVo systemUserVo);

    List<SystemUser> queryUserAudioList(SystemUserVo vo);

    Integer queryUserAudioListCount(SystemUserVo vo);
}
