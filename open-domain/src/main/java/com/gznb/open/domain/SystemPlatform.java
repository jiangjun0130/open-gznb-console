package com.gznb.open.domain;

import java.io.Serializable;
import java.util.Date;

public class SystemPlatform implements Serializable {
    private Integer id;

    private String platformName;

    private String encryptType;

    private String platformStatus;

    private String platformImage;

    private String description;

    private String testUrl;

    private String preUrl;

    private String prdUrl;

    private String note;

    private Date updateTime;

    private Date createTime;

    private String updateUser;

    private String createUser;

    private String platformManager;

    private String platformNo;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName == null ? null : platformName.trim();
    }

    public String getEncryptType() {
        return encryptType;
    }

    public void setEncryptType(String encryptType) {
        this.encryptType = encryptType == null ? null : encryptType.trim();
    }

    public String getPlatformStatus() {
        return platformStatus;
    }

    public void setPlatformStatus(String platformStatus) {
        this.platformStatus = platformStatus == null ? null : platformStatus.trim();
    }

    public String getPlatformImage() {
        return platformImage;
    }

    public void setPlatformImage(String platformImage) {
        this.platformImage = platformImage == null ? null : platformImage.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getTestUrl() {
        return testUrl;
    }

    public void setTestUrl(String testUrl) {
        this.testUrl = testUrl == null ? null : testUrl.trim();
    }

    public String getPreUrl() {
        return preUrl;
    }

    public void setPreUrl(String preUrl) {
        this.preUrl = preUrl == null ? null : preUrl.trim();
    }

    public String getPrdUrl() {
        return prdUrl;
    }

    public void setPrdUrl(String prdUrl) {
        this.prdUrl = prdUrl == null ? null : prdUrl.trim();
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

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getPlatformManager() {
        return platformManager;
    }

    public void setPlatformManager(String platformManager) {
        this.platformManager = platformManager == null ? null : platformManager.trim();
    }

    public String getPlatformNo() {
        return platformNo;
    }

    public void setPlatformNo(String platformNo) {
        this.platformNo = platformNo == null ? null : platformNo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", platformName=").append(platformName);
        sb.append(", encryptType=").append(encryptType);
        sb.append(", platformStatus=").append(platformStatus);
        sb.append(", platformImage=").append(platformImage);
        sb.append(", description=").append(description);
        sb.append(", testUrl=").append(testUrl);
        sb.append(", preUrl=").append(preUrl);
        sb.append(", prdUrl=").append(prdUrl);
        sb.append(", note=").append(note);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", createUser=").append(createUser);
        sb.append(", platformManager=").append(platformManager);
        sb.append(", platformNo=").append(platformNo);
        sb.append("]");
        return sb.toString();
    }
}