package com.gznb.open.domain;

import java.io.Serializable;
import java.util.Date;

public class BusinessPlatformChannel implements Serializable {
    private Integer id;

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

    private String channelMerId;

    private String channelOpenId;

    private String busMerchantNo;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        this.busChannelNo = busChannelNo == null ? null : busChannelNo.trim();
    }

    public String getBusChannelName() {
        return busChannelName;
    }

    public void setBusChannelName(String busChannelName) {
        this.busChannelName = busChannelName == null ? null : busChannelName.trim();
    }

    public String getBusChannelType() {
        return busChannelType;
    }

    public void setBusChannelType(String busChannelType) {
        this.busChannelType = busChannelType == null ? null : busChannelType.trim();
    }

    public String getChannelStatus() {
        return channelStatus;
    }

    public void setChannelStatus(String channelStatus) {
        this.channelStatus = channelStatus == null ? null : channelStatus.trim();
    }

    public String getEnvFlag() {
        return envFlag;
    }

    public void setEnvFlag(String envFlag) {
        this.envFlag = envFlag == null ? null : envFlag.trim();
    }

    public String getChannelAppId() {
        return channelAppId;
    }

    public void setChannelAppId(String channelAppId) {
        this.channelAppId = channelAppId == null ? null : channelAppId.trim();
    }

    public String getChannelEncryptType() {
        return channelEncryptType;
    }

    public void setChannelEncryptType(String channelEncryptType) {
        this.channelEncryptType = channelEncryptType == null ? null : channelEncryptType.trim();
    }

    public String getCertPath() {
        return certPath;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath == null ? null : certPath.trim();
    }

    public String getCertPassword() {
        return certPassword;
    }

    public void setCertPassword(String certPassword) {
        this.certPassword = certPassword == null ? null : certPassword.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
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
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public String getChannelMerId() {
        return channelMerId;
    }

    public void setChannelMerId(String channelMerId) {
        this.channelMerId = channelMerId == null ? null : channelMerId.trim();
    }

    public String getChannelOpenId() {
        return channelOpenId;
    }

    public void setChannelOpenId(String channelOpenId) {
        this.channelOpenId = channelOpenId == null ? null : channelOpenId.trim();
    }

    public String getBusMerchantNo() {
        return busMerchantNo;
    }

    public void setBusMerchantNo(String busMerchantNo) {
        this.busMerchantNo = busMerchantNo == null ? null : busMerchantNo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", busMerchantId=").append(busMerchantId);
        sb.append(", busChannelNo=").append(busChannelNo);
        sb.append(", busChannelName=").append(busChannelName);
        sb.append(", busChannelType=").append(busChannelType);
        sb.append(", channelStatus=").append(channelStatus);
        sb.append(", envFlag=").append(envFlag);
        sb.append(", channelAppId=").append(channelAppId);
        sb.append(", channelEncryptType=").append(channelEncryptType);
        sb.append(", certPath=").append(certPath);
        sb.append(", certPassword=").append(certPassword);
        sb.append(", description=").append(description);
        sb.append(", note=").append(note);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", channelMerId=").append(channelMerId);
        sb.append(", channelOpenId=").append(channelOpenId);
        sb.append(", busMerchantNo=").append(busMerchantNo);
        sb.append("]");
        return sb.toString();
    }
}