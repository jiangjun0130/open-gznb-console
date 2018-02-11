package com.gznb.open.domain;

import java.io.Serializable;
import java.util.Date;

public class OpenPlatformEncrypt implements Serializable {
    private Integer id;

    private String encryptType;

    private String publicKeyUri;

    private String privateKeyUri;

    private String envFlag;

    private String encryptStatus;

    private String note;

    private Date updateTime;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEncryptType() {
        return encryptType;
    }

    public void setEncryptType(String encryptType) {
        this.encryptType = encryptType == null ? null : encryptType.trim();
    }

    public String getPublicKeyUri() {
        return publicKeyUri;
    }

    public void setPublicKeyUri(String publicKeyUri) {
        this.publicKeyUri = publicKeyUri == null ? null : publicKeyUri.trim();
    }

    public String getPrivateKeyUri() {
        return privateKeyUri;
    }

    public void setPrivateKeyUri(String privateKeyUri) {
        this.privateKeyUri = privateKeyUri == null ? null : privateKeyUri.trim();
    }

    public String getEnvFlag() {
        return envFlag;
    }

    public void setEnvFlag(String envFlag) {
        this.envFlag = envFlag == null ? null : envFlag.trim();
    }

    public String getEncryptStatus() {
        return encryptStatus;
    }

    public void setEncryptStatus(String encryptStatus) {
        this.encryptStatus = encryptStatus == null ? null : encryptStatus.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", encryptType=").append(encryptType);
        sb.append(", publicKeyUri=").append(publicKeyUri);
        sb.append(", privateKeyUri=").append(privateKeyUri);
        sb.append(", envFlag=").append(envFlag);
        sb.append(", encryptStatus=").append(encryptStatus);
        sb.append(", note=").append(note);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}