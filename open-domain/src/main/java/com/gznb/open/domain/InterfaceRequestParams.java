package com.gznb.open.domain;

import java.io.Serializable;
import java.util.Date;

public class InterfaceRequestParams implements Serializable {
    private Integer id;

    private Integer interfaceId;

    private String paramName;

    private String paramNameCn;

    private String paramType;

    private Boolean paramRequired;

    private String paramTestValue;

    private String paramStatus;

    private String description;

    private String note;

    private Date updateTime;

    private Date createTime;

    private String createUser;

    private String updateUser;

    private String paramTree;

    private Integer parentId;

    private String commonFlag;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Integer interfaceId) {
        this.interfaceId = interfaceId;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName == null ? null : paramName.trim();
    }

    public String getParamNameCn() {
        return paramNameCn;
    }

    public void setParamNameCn(String paramNameCn) {
        this.paramNameCn = paramNameCn == null ? null : paramNameCn.trim();
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType == null ? null : paramType.trim();
    }

    public Boolean getParamRequired() {
        return paramRequired;
    }

    public void setParamRequired(Boolean paramRequired) {
        this.paramRequired = paramRequired;
    }

    public String getParamTestValue() {
        return paramTestValue;
    }

    public void setParamTestValue(String paramTestValue) {
        this.paramTestValue = paramTestValue == null ? null : paramTestValue.trim();
    }

    public String getParamStatus() {
        return paramStatus;
    }

    public void setParamStatus(String paramStatus) {
        this.paramStatus = paramStatus == null ? null : paramStatus.trim();
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

    public String getParamTree() {
        return paramTree;
    }

    public void setParamTree(String paramTree) {
        this.paramTree = paramTree == null ? null : paramTree.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCommonFlag() {
        return commonFlag;
    }

    public void setCommonFlag(String commonFlag) {
        this.commonFlag = commonFlag == null ? null : commonFlag.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", interfaceId=").append(interfaceId);
        sb.append(", paramName=").append(paramName);
        sb.append(", paramNameCn=").append(paramNameCn);
        sb.append(", paramType=").append(paramType);
        sb.append(", paramRequired=").append(paramRequired);
        sb.append(", paramTestValue=").append(paramTestValue);
        sb.append(", paramStatus=").append(paramStatus);
        sb.append(", description=").append(description);
        sb.append(", note=").append(note);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", paramTree=").append(paramTree);
        sb.append(", parentId=").append(parentId);
        sb.append(", commonFlag=").append(commonFlag);
        sb.append("]");
        return sb.toString();
    }
}