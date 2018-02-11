package com.gznb.open.domain;

import java.io.Serializable;

public class BusinessPlatformChannelWithBLOBs extends BusinessPlatformChannel implements Serializable {
    private String md5Key;

    private String reqPrivateKey;

    private String resPublicKey;

    private static final long serialVersionUID = 1L;

    public String getMd5Key() {
        return md5Key;
    }

    public void setMd5Key(String md5Key) {
        this.md5Key = md5Key == null ? null : md5Key.trim();
    }

    public String getReqPrivateKey() {
        return reqPrivateKey;
    }

    public void setReqPrivateKey(String reqPrivateKey) {
        this.reqPrivateKey = reqPrivateKey == null ? null : reqPrivateKey.trim();
    }

    public String getResPublicKey() {
        return resPublicKey;
    }

    public void setResPublicKey(String resPublicKey) {
        this.resPublicKey = resPublicKey == null ? null : resPublicKey.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", md5Key=").append(md5Key);
        sb.append(", reqPrivateKey=").append(reqPrivateKey);
        sb.append(", resPublicKey=").append(resPublicKey);
        sb.append("]");
        return sb.toString();
    }
}