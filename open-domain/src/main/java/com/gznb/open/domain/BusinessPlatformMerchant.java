package com.gznb.open.domain;

import java.io.Serializable;
import java.util.Date;

public class BusinessPlatformMerchant implements Serializable {
    private Integer id;

    private Integer platformId;

    private Integer busPlatformId;

    private String merchantNo;

    private String merchantName;

    private String merchantStatus;

    private Date updateTime;

    private Date createTime;

    private String createUser;

    private String updateUser;

    private String platformNo;

    private String busPlatformNo;

    private String merchantUuid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    public String getMerchantStatus() {
        return merchantStatus;
    }

    public void setMerchantStatus(String merchantStatus) {
        this.merchantStatus = merchantStatus == null ? null : merchantStatus.trim();
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

    public String getPlatformNo() {
        return platformNo;
    }

    public void setPlatformNo(String platformNo) {
        this.platformNo = platformNo == null ? null : platformNo.trim();
    }

    public String getBusPlatformNo() {
        return busPlatformNo;
    }

    public void setBusPlatformNo(String busPlatformNo) {
        this.busPlatformNo = busPlatformNo == null ? null : busPlatformNo.trim();
    }

    public String getMerchantUuid() {
        return merchantUuid;
    }

    public void setMerchantUuid(String merchantUuid) {
        this.merchantUuid = merchantUuid == null ? null : merchantUuid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", platformId=").append(platformId);
        sb.append(", busPlatformId=").append(busPlatformId);
        sb.append(", merchantNo=").append(merchantNo);
        sb.append(", merchantName=").append(merchantName);
        sb.append(", merchantStatus=").append(merchantStatus);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", platformNo=").append(platformNo);
        sb.append(", busPlatformNo=").append(busPlatformNo);
        sb.append(", merchantUuid=").append(merchantUuid);
        sb.append("]");
        return sb.toString();
    }
}