package com.gznb.open.domain.custom;

import com.gznb.open.domain.BusSystemAccess;

import java.io.Serializable;

/**
 * Created by kl09 on 2017/6/30.
 */
public class BusSystemAccessCustom extends BusSystemAccess implements Serializable {

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
}
