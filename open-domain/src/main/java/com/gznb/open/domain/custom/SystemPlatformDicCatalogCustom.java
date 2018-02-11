package com.gznb.open.domain.custom;

import com.gznb.open.domain.SystemDic;
import com.gznb.open.domain.SystemPlatformDicCatalog;

import java.util.Date;
import java.util.List;

/**
 * Created by zhenglin on 2017/10/18.
 */
public class SystemPlatformDicCatalogCustom extends SystemPlatformDicCatalog {
    private Integer catalogId;

    private String dicName;

    private String dicValue;
    private List<SystemDic> systemDicList;
    private Integer dicStatus;

    public Integer getDicStatus() {
        return dicStatus;
    }

    public void setDicStatus(Integer dicStatus) {
        this.dicStatus = dicStatus;
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName;
    }

    public String getDicValue() {
        return dicValue;
    }

    public void setDicValue(String dicValue) {
        this.dicValue = dicValue;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public List<SystemDic> getSystemDicList() {
        return systemDicList;
    }

    public void setSystemDicList(List<SystemDic> systemDicList) {
        this.systemDicList = systemDicList;
    }
}
