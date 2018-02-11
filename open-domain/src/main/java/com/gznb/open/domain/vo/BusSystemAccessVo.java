package com.gznb.open.domain.vo;

import com.gznb.open.domain.vo.base.BaseQueryVo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kl09 on 2017/6/30.
 */
public class BusSystemAccessVo extends BaseQueryVo implements Serializable {

    /**
     * 系统平台标识
     */
    private Integer platformId;

    /**
     * 业务系统表示
     */
    private Integer busPlatformId;

    private Integer moduleId;

    private String applyUser;

    private String accessStatus;

    private Date updateTime;

    private Date createTime;

    private String createUser;

    private String updateUser;

    /**
     * 平台名称，用于查询
     */
    private String platformName;


    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public Integer getBusPlatformId() {
        return busPlatformId;
    }

    public void setBusPlatformId(Integer busPlatformId) {
        this.busPlatformId = busPlatformId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getAccessStatus() {
        return accessStatus;
    }

    public void setAccessStatus(String accessStatus) {
        this.accessStatus = accessStatus;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    @Override
    public String toString() {
        return "BusSystemAccessVo{" +
                "platformId=" + platformId +
                ", busPlatformId=" + busPlatformId +
                ", moduleId=" + moduleId +
                ", applyUser='" + applyUser + '\'' +
                ", accessStatus='" + accessStatus + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", createUser='" + createUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                ", platformName='" + platformName + '\'' +
                '}';
    }
}
