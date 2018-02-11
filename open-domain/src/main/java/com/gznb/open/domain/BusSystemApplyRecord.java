package com.gznb.open.domain;

import java.io.Serializable;
import java.util.Date;

public class BusSystemApplyRecord implements Serializable {
    private Integer id;

    private Integer busPlatformId;

    private Integer platformId;

    private Integer moduleId;

    private String applyUser;

    private String applyEmail;

    private String applyMobile;

    private String applyDescription;

    private String applyStatus;

    private String auditUser;

    private String auditResult;

    private String auditDescription;

    private Date updateTime;

    private Date createTime;

    private String createUser;

    private String updateUser;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBusPlatformId() {
        return busPlatformId;
    }

    public void setBusPlatformId(Integer busPlatformId) {
        this.busPlatformId = busPlatformId;
    }

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
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
        this.applyUser = applyUser == null ? null : applyUser.trim();
    }

    public String getApplyEmail() {
        return applyEmail;
    }

    public void setApplyEmail(String applyEmail) {
        this.applyEmail = applyEmail == null ? null : applyEmail.trim();
    }

    public String getApplyMobile() {
        return applyMobile;
    }

    public void setApplyMobile(String applyMobile) {
        this.applyMobile = applyMobile == null ? null : applyMobile.trim();
    }

    public String getApplyDescription() {
        return applyDescription;
    }

    public void setApplyDescription(String applyDescription) {
        this.applyDescription = applyDescription == null ? null : applyDescription.trim();
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus == null ? null : applyStatus.trim();
    }

    public String getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser == null ? null : auditUser.trim();
    }

    public String getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(String auditResult) {
        this.auditResult = auditResult == null ? null : auditResult.trim();
    }

    public String getAuditDescription() {
        return auditDescription;
    }

    public void setAuditDescription(String auditDescription) {
        this.auditDescription = auditDescription == null ? null : auditDescription.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", busPlatformId=").append(busPlatformId);
        sb.append(", platformId=").append(platformId);
        sb.append(", moduleId=").append(moduleId);
        sb.append(", applyUser=").append(applyUser);
        sb.append(", applyEmail=").append(applyEmail);
        sb.append(", applyMobile=").append(applyMobile);
        sb.append(", applyDescription=").append(applyDescription);
        sb.append(", applyStatus=").append(applyStatus);
        sb.append(", auditUser=").append(auditUser);
        sb.append(", auditResult=").append(auditResult);
        sb.append(", auditDescription=").append(auditDescription);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append("]");
        return sb.toString();
    }
}