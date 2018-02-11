package com.gznb.open.domain.vo;

import com.gznb.open.domain.vo.base.BaseQueryVo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kl09 on 2017/6/30.
 */
public class BusSystemApplyRecordVo extends BaseQueryVo implements Serializable {

    /**
     * 业务系统（应用）id
     */
    private Integer busPlatformId;

    /**
     * 系统平台id
     */
    private Integer platformId;

    /**
     * 系统平台模块ID
     */
    private Integer moduleId;

    /**
     * 申请人。默认为邮箱地址
     */
    private String applyUser;

    /**
     * 申请人箱地址
     */
    private String applyEmail;

    /**
     * 申请人电话
     */
    private String applyMobile;

    private String applyDescription;

    /**
     * 申请状态。1：初始申请；2：审核中；3：审核完成
     */
    private String applyStatus;

    private String auditUser;

    /**
     * 申请审核结果。1：通过；2：未通过
     */
    private String auditResult;

    private String auditDescription;

    private Date updateTime;

    private Date createTime;

    private String createUser;

    private String updateUser;

    /**
     * 平台名称
     */
    private String platformName;

    private String description;

    /**
     * 平台系统管理人
     */
    private String platformManager;
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
        this.applyUser = applyUser;
    }

    public String getApplyEmail() {
        return applyEmail;
    }

    public void setApplyEmail(String applyEmail) {
        this.applyEmail = applyEmail;
    }

    public String getApplyMobile() {
        return applyMobile;
    }

    public void setApplyMobile(String applyMobile) {
        this.applyMobile = applyMobile;
    }

    public String getApplyDescription() {
        return applyDescription;
    }

    public void setApplyDescription(String applyDescription) {
        this.applyDescription = applyDescription;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser;
    }

    public String getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(String auditResult) {
        this.auditResult = auditResult;
    }

    public String getAuditDescription() {
        return auditDescription;
    }

    public void setAuditDescription(String auditDescription) {
        this.auditDescription = auditDescription;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlatformManager() { return platformManager; }

    public void setPlatformManager(String platformManager) { this.platformManager = platformManager; }
}
