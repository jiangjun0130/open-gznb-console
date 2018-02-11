package com.gznb.open.domain;

import java.io.Serializable;
import java.util.Date;

public class InterfaceReqParamSample implements Serializable {
    private Integer id;

    private Integer interfaceId;

    private String sampleUri;

    private Date updateTime;

    private Date createTime;

    private String createUser;

    private String updateUser;

    private String requestSample;

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

    public String getSampleUri() {
        return sampleUri;
    }

    public void setSampleUri(String sampleUri) {
        this.sampleUri = sampleUri == null ? null : sampleUri.trim();
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

    public String getRequestSample() {
        return requestSample;
    }

    public void setRequestSample(String requestSample) {
        this.requestSample = requestSample == null ? null : requestSample.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", interfaceId=").append(interfaceId);
        sb.append(", sampleUri=").append(sampleUri);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", requestSample=").append(requestSample);
        sb.append("]");
        return sb.toString();
    }
}