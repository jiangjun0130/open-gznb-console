package com.gznb.open.domain.vo;

import com.gznb.open.domain.vo.base.BaseQueryVo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kl09 on 2017/6/30.
 */
public class BusinessPlatformVo extends BaseQueryVo implements Serializable {

    private String platformNo;

    private String platformName;

    private String platformStatus;

    private String description;

    private String note;

    private Date updateTime;

    private Date createTime;

    private String createUser;

    private String updateUser;

    /**
     * 申请人电话
     */
    private String applyUserPhone;
    /**
     * 申请人邮箱
     */
    private String applyUserEmail;

    public String getPlatformNo() {
        return platformNo;
    }

    public void setPlatformNo(String platformNo) {
        this.platformNo = platformNo;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformStatus() {
        return platformStatus;
    }

    public void setPlatformStatus(String platformStatus) {
        this.platformStatus = platformStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public String getApplyUserPhone() {
        return applyUserPhone;
    }

    public void setApplyUserPhone(String applyUserPhone) {
        this.applyUserPhone = applyUserPhone;
    }

    public String getApplyUserEmail() {
        return applyUserEmail;
    }

    public void setApplyUserEmail(String applyUserEmail) {
        this.applyUserEmail = applyUserEmail;
    }

    @Override
    public String toString() {
        return "BusinessPlatformVo{" +
                "platformNo='" + platformNo + '\'' +
                ", platformName='" + platformName + '\'' +
                ", platformStatus='" + platformStatus + '\'' +
                ", description='" + description + '\'' +
                ", note='" + note + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", createUser='" + createUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                ", applyUserPhone='" + applyUserPhone + '\'' +
                ", applyUserEmail='" + applyUserEmail + '\'' +
                '}';
    }
}
