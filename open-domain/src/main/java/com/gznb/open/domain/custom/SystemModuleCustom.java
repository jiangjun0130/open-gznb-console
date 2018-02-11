package com.gznb.open.domain.custom;

import com.gznb.open.domain.SystemInterface;
import com.gznb.open.domain.SystemModule;

import java.io.Serializable;
import java.util.List;

/**
 * 系统模块扩展实体
 *
 * Created by jj02 on 2017/6/28.
 */
public class SystemModuleCustom extends SystemModule implements Serializable {

    /**
     * 系统平台名称
     */
    private String platformName;

    /**
     * 状态名称
     */
    private String moduleStatusName;

    /**
     * 模块对应接口列表
     */
    private List<SystemInterface> interfaceList;

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getModuleStatusName() {
        return moduleStatusName;
    }

    public void setModuleStatusName(String moduleStatusName) {
        this.moduleStatusName = moduleStatusName;
    }

    public List<SystemInterface> getInterfaceList() {
        return interfaceList;
    }

    public void setInterfaceList(List<SystemInterface> interfaceList) {
        this.interfaceList = interfaceList;
    }
}
