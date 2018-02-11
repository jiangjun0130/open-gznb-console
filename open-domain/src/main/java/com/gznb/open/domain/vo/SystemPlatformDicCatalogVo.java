package com.gznb.open.domain.vo;

import com.gznb.open.domain.vo.base.BaseQueryVo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhenglin on 2017/10/18.
 */
public class SystemPlatformDicCatalogVo extends BaseQueryVo implements Serializable {

    private Integer platformId;

    private String catalogType;

    private String catalogName;

    private String catalogDesc;

    private String catalogStatus;

    private String note;

    private Date updateTime;

    private Date createTime;

    private String createUser;

    private String updateUser;

    private static final long serialVersionUID = 1L;

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

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

    public String getCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(String catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
