package com.gznb.open.domain;

import java.io.Serializable;
import java.util.Date;

public class SystemUser implements Serializable {
    private Integer id;

    private String userName;

    private String mobile;

    private String userType;

    private Date updateTime;

    private Date registerTime;

    private Date createUser;

    private String note;

    private Integer audioStatus;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Date createUser) {
        this.createUser = createUser;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getAudioStatus() {
        return audioStatus;
    }

    public void setAudioStatus(Integer audioStatus) {
        this.audioStatus = audioStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", mobile=").append(mobile);
        sb.append(", userType=").append(userType);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", registerTime=").append(registerTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", note=").append(note);
        sb.append(", audioStatus=").append(audioStatus);
        sb.append("]");
        return sb.toString();
    }
}