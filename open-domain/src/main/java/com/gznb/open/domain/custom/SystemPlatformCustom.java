package com.gznb.open.domain.custom;

import com.gznb.open.domain.SystemPlatform;

import java.io.Serializable;

public class SystemPlatformCustom extends SystemPlatform implements Serializable {

    /**
     * 加密类型名称
     */
    private String encryptTypeName;

    /**
     * 状态名称
     */
    private String platformStatusName;

    public String getEncryptTypeName() {
        return encryptTypeName;
    }

    public void setEncryptTypeName(String encryptTypeName) {
        this.encryptTypeName = encryptTypeName;
    }

    public String getPlatformStatusName() {
        return platformStatusName;
    }

    public void setPlatformStatusName(String platformStatusName) {
        this.platformStatusName = platformStatusName;
    }
}