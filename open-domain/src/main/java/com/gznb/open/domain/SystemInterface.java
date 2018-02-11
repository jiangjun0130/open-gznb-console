package com.gznb.open.domain;

import java.io.Serializable;
import java.util.Date;

public class SystemInterface implements Serializable {
    private Integer id;

    private Integer platformId;

    private Integer moduleId;

    private String interfaceName;

    private String interfaceUrl;

    private String requestMode;

    private String requestParamFormat;

    private String interfaceStatus;

    private String interfaceVersion;

    private Integer interfaceSort;

    private String description;

    private String note;

    private Date updateTime;

    private Date createTime;

    private String createUser;

    private String updateUser;

    private String responseParamFormat;

    private String reqParamWrapperType;

    private String reqSignDesc;

    private String respParamWrapperType;

    private String respSignDesc;

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

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName == null ? null : interfaceName.trim();
    }

    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    public void setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl == null ? null : interfaceUrl.trim();
    }

    public String getRequestMode() {
        return requestMode;
    }

    public void setRequestMode(String requestMode) {
        this.requestMode = requestMode == null ? null : requestMode.trim();
    }

    public String getRequestParamFormat() {
        return requestParamFormat;
    }

    public void setRequestParamFormat(String requestParamFormat) {
        this.requestParamFormat = requestParamFormat == null ? null : requestParamFormat.trim();
    }

    public String getInterfaceStatus() {
        return interfaceStatus;
    }

    public void setInterfaceStatus(String interfaceStatus) {
        this.interfaceStatus = interfaceStatus == null ? null : interfaceStatus.trim();
    }

    public String getInterfaceVersion() {
        return interfaceVersion;
    }

    public void setInterfaceVersion(String interfaceVersion) {
        this.interfaceVersion = interfaceVersion == null ? null : interfaceVersion.trim();
    }

    public Integer getInterfaceSort() {
        return interfaceSort;
    }

    public void setInterfaceSort(Integer interfaceSort) {
        this.interfaceSort = interfaceSort;
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

    public String getResponseParamFormat() {
        return responseParamFormat;
    }

    public void setResponseParamFormat(String responseParamFormat) {
        this.responseParamFormat = responseParamFormat == null ? null : responseParamFormat.trim();
    }

    public String getReqParamWrapperType() {
        return reqParamWrapperType;
    }

    public void setReqParamWrapperType(String reqParamWrapperType) {
        this.reqParamWrapperType = reqParamWrapperType == null ? null : reqParamWrapperType.trim();
    }

    public String getReqSignDesc() {
        return reqSignDesc;
    }

    public void setReqSignDesc(String reqSignDesc) {
        this.reqSignDesc = reqSignDesc == null ? null : reqSignDesc.trim();
    }

    public String getRespParamWrapperType() {
        return respParamWrapperType;
    }

    public void setRespParamWrapperType(String respParamWrapperType) {
        this.respParamWrapperType = respParamWrapperType == null ? null : respParamWrapperType.trim();
    }

    public String getRespSignDesc() {
        return respSignDesc;
    }

    public void setRespSignDesc(String respSignDesc) {
        this.respSignDesc = respSignDesc == null ? null : respSignDesc.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", platformId=").append(platformId);
        sb.append(", moduleId=").append(moduleId);
        sb.append(", interfaceName=").append(interfaceName);
        sb.append(", interfaceUrl=").append(interfaceUrl);
        sb.append(", requestMode=").append(requestMode);
        sb.append(", requestParamFormat=").append(requestParamFormat);
        sb.append(", interfaceStatus=").append(interfaceStatus);
        sb.append(", interfaceVersion=").append(interfaceVersion);
        sb.append(", interfaceSort=").append(interfaceSort);
        sb.append(", description=").append(description);
        sb.append(", note=").append(note);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", responseParamFormat=").append(responseParamFormat);
        sb.append(", reqParamWrapperType=").append(reqParamWrapperType);
        sb.append(", reqSignDesc=").append(reqSignDesc);
        sb.append(", respParamWrapperType=").append(respParamWrapperType);
        sb.append(", respSignDesc=").append(respSignDesc);
        sb.append("]");
        return sb.toString();
    }
}