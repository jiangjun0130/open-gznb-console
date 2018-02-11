package com.gznb.open.domain;

import java.io.Serializable;

public class SystemDic extends SystemDicKey implements Serializable {
    private String dicTypeName;

    private String dicName;

    private String dicValue;

    private Integer dicStatus;

    private String note;

    private static final long serialVersionUID = 1L;

    public String getDicTypeName() {
        return dicTypeName;
    }

    public void setDicTypeName(String dicTypeName) {
        this.dicTypeName = dicTypeName == null ? null : dicTypeName.trim();
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName == null ? null : dicName.trim();
    }

    public String getDicValue() {
        return dicValue;
    }

    public void setDicValue(String dicValue) {
        this.dicValue = dicValue == null ? null : dicValue.trim();
    }

    public Integer getDicStatus() {
        return dicStatus;
    }

    public void setDicStatus(Integer dicStatus) {
        this.dicStatus = dicStatus;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dicTypeName=").append(dicTypeName);
        sb.append(", dicName=").append(dicName);
        sb.append(", dicValue=").append(dicValue);
        sb.append(", dicStatus=").append(dicStatus);
        sb.append(", note=").append(note);
        sb.append("]");
        return sb.toString();
    }
}