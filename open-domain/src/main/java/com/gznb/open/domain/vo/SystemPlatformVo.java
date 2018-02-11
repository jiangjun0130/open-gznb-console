package com.gznb.open.domain.vo;

import com.gznb.open.domain.vo.base.BaseQueryVo;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * 系统平台查询实体
 *
 * Created by jj02 on 2017/6/15.
 */
public class SystemPlatformVo extends BaseQueryVo implements Serializable{

    /**
     * 主键id
     */
    //@Min(value = 1, message = "唯一标识无效！")
    private Integer platformId;

    /**
     * 平台编号
     */
    private String platformNo;

    private Integer moduleId;

    /**
     * 系统平台名称
     */
    @NotBlank(message = "系统平台名称不能为空！")
    private String platformName;

    /**
     * 系统平台加密类型
     */
    @NotBlank(message = "系统平台加密类型不能为空！")
    private String encryptType;

    /**
     * 状态
     */
    private String status;

    /**
     * 系统平台描述
     */
    @NotBlank(message = "系统平台描述不能为空！")
    private String description;

    /**
     * 系统封面图片
     */
    private String imageUrl;

    /**
     * 测试环境地址
     */
    private String testEnvUrl;

    /**
     * 准生产环境地址
     */
    private String preEnvUrl;

    /**
     * 生产环境地址
     */
    private String prdEnvUrl;

    /**
     * 备注信息
     */
    private String note;

    public String getPlatformNo() {
        return platformNo;
    }

    public void setPlatformNo(String platformNo) {
        this.platformNo = platformNo;
    }

    /**
     * 系统平台负责人邮箱
     */
    private String platformManager;

    private String createUser;

    private String updateUser;

    public Integer getModuleId() {
        return moduleId;
    }

    public String getPlatformManager() {
        return platformManager;
    }

    public void setPlatformManager(String platformManager) {
        this.platformManager = platformManager;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getEncryptType() {
        return encryptType;
    }

    public void setEncryptType(String encryptType) {
        this.encryptType = encryptType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTestEnvUrl() {
        return testEnvUrl;
    }

    public void setTestEnvUrl(String testEnvUrl) {
        this.testEnvUrl = testEnvUrl;
    }

    public String getPreEnvUrl() {
        return preEnvUrl;
    }

    public void setPreEnvUrl(String preEnvUrl) {
        this.preEnvUrl = preEnvUrl;
    }

    public String getPrdEnvUrl() {
        return prdEnvUrl;
    }

    public void setPrdEnvUrl(String prdEnvUrl) {
        this.prdEnvUrl = prdEnvUrl;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        return "SystemPlatformVo{" +
                "platformId=" + platformId +
                ", moduleId=" + moduleId +
                ", platformName='" + platformName + '\'' +
                ", encryptType='" + encryptType + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", testEnvUrl='" + testEnvUrl + '\'' +
                ", preEnvUrl='" + preEnvUrl + '\'' +
                ", prdEnvUrl='" + prdEnvUrl + '\'' +
                ", note='" + note + '\'' +
                ", platformManager='" + platformManager + '\'' +
                ", createUser='" + createUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                '}';
    }
}
