package com.gznb.open.domain.vo;

import com.gznb.open.domain.vo.base.BaseQueryVo;

import java.io.Serializable;
import java.util.Date;

public class BusinessPlatformChannelVo extends BaseQueryVo implements Serializable {

    private Integer busMerchantId;

    private String busChannelNo;

    private String busChannelName;

    private String busChannelType;

    private String channelStatus;

    private String envFlag;

    private String channelAppId;

    private String channelEncryptType;

    private String certPath;

    private String certPassword;

    private String description;

    private String note;

    private Date updateTime;

    private Date createTime;

    private String createUser;

    private String updateUser;

    public Integer getBusMerchantId() {
        return busMerchantId;
    }

    public void setBusMerchantId(Integer busMerchantId) {
        this.busMerchantId = busMerchantId;
    }

    public String getBusChannelNo() {
        return busChannelNo;
    }

    public void setBusChannelNo(String busChannelNo) {
        this.busChannelNo = busChannelNo;
    }

    public String getBusChannelName() {
        return busChannelName;
    }

    public void setBusChannelName(String busChannelName) {
        this.busChannelName = busChannelName;
    }

    public String getBusChannelType() {
        return busChannelType;
    }

    public void setBusChannelType(String busChannelType) {
        this.busChannelType = busChannelType;
    }

    public String getChannelStatus() {
        return channelStatus;
    }

    public void setChannelStatus(String channelStatus) {
        this.channelStatus = channelStatus;
    }

    public String getEnvFlag() {
        return envFlag;
    }

    public void setEnvFlag(String envFlag) {
        this.envFlag = envFlag;
    }

    public String getChannelAppId() {
        return channelAppId;
    }

    public void setChannelAppId(String channelAppId) {
        this.channelAppId = channelAppId;
    }

    public String getChannelEncryptType() {
        return channelEncryptType;
    }

    public void setChannelEncryptType(String channelEncryptType) {
        this.channelEncryptType = channelEncryptType;
    }

    public String getCertPath() {
        return certPath;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }

    public String getCertPassword() {
        return certPassword;
    }

    public void setCertPassword(String certPassword) {
        this.certPassword = certPassword;
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

    @Override
    public String toString() {
        return "BusinessPlatformChannelVo{" +
                "busMerchantId=" + busMerchantId +
                ", busChannelNo='" + busChannelNo + '\'' +
                ", busChannelName='" + busChannelName + '\'' +
                ", busChannelType='" + busChannelType + '\'' +
                ", channelStatus='" + channelStatus + '\'' +
                ", envFlag='" + envFlag + '\'' +
                ", channelAppId='" + channelAppId + '\'' +
                ", channelEncryptType='" + channelEncryptType + '\'' +
                ", certPath='" + certPath + '\'' +
                ", certPassword='" + certPassword + '\'' +
                ", description='" + description + '\'' +
                ", note='" + note + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", createUser='" + createUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                '}';
    }
}