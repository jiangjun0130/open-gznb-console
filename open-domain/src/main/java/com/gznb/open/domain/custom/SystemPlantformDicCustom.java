package com.gznb.open.domain.custom;

import com.gznb.open.domain.SystemPlatformDicCatalog;
import com.gznb.open.domain.vo.base.BaseQueryVo;

import java.io.Serializable;
import java.security.PrivateKey;

/**
 * Created by zhenglin on 2017/7/24.
 */
public class SystemPlantformDicCustom extends BaseQueryVo implements Serializable {

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    /**
     * 目录类型id
     */
    private Integer catalogId;
    /**
     * 目录类型
     */
    private String catalogType;
    /**
     * 目录名称
     */
    private String catalogName;
    /**
     * 目录说明
     */
    private String catalogDesc;
    /**
     * 字典名称
     */
    private String dicName;
    /**
     * 字典状态
     */
    private String dicStatus;

    public String getCatalogType() {
        return catalogType;
    }

    public void setCatalogType(String catalogType) {
        this.catalogType = catalogType;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getCatalogDesc() {
        return catalogDesc;
    }

    public void setCatalogDesc(String catalogDesc) {
        this.catalogDesc = catalogDesc;
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName;
    }

    public String getDicStatus() {
        return dicStatus;
    }

    public void setDicStatus(String dicStatus) {
        this.dicStatus = dicStatus;
    }

    public String getDicValue() {
        return dicValue;
    }

    public void setDicValue(String dicValue) {
        this.dicValue = dicValue;
    }

    /**
     * 字典值
     */

    private String dicValue;
}
