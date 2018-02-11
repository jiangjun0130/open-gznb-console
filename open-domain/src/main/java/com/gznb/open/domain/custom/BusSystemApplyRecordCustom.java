package com.gznb.open.domain.custom;

import com.gznb.open.domain.BusSystemApplyRecord;

import java.io.Serializable;

/**
 * Created by kl09 on 2017/6/30.
 */
public class BusSystemApplyRecordCustom extends BusSystemApplyRecord implements Serializable {
    /**
     * 系统平台名称
     */
    private String platformName;
    /**
     * 业务系统（应用）名称
     */
    private String busPlatformName;
    /**
     * 系统平台模块
     */
    private String moduleName;
    /**
     * 描述
     */
    private String description;

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getBusPlatformName() {
        return busPlatformName;
    }

    public void setBusPlatformName(String busPlatformName) {
        this.busPlatformName = busPlatformName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
