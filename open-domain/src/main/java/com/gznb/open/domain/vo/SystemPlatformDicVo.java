package com.gznb.open.domain.vo;

import com.gznb.open.domain.vo.base.BaseQueryVo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhenglin on 2017/7/28.
 */
public class SystemPlatformDicVo extends BaseQueryVo implements Serializable {

    /**
     * 字典目录id
     */
    private Integer dicdataId;

    private List<SystemDicVo> dicList;

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

    public String getDicStatus() {
        return dicStatus;
    }

    public void setDicStatus(String dicStatus) {
        this.dicStatus = dicStatus;
    }

    /**
     * 字典名称
     */
    private String dicName;

    /**
     * 字典值
     */
    private String dicValue;

    /**
     * 字典状态
     */
    private String dicStatus;

    public List<SystemDicVo> getDicList() {
        return dicList;
    }

    public void setDicList(List<SystemDicVo> dicList) {
        this.dicList = dicList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *创建人
     */
    private String userName;

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    private Integer catalogId;

    public String[] getDicData() {
        return dicData;
    }

    public void setDicData(String[] dicData) {
        this.dicData = dicData;
    }

    private String[] dicData;

    public Integer getDicdataId() {
        return dicdataId;
    }

    public void setDicdataId(Integer dicdataId) {
        this.dicdataId = dicdataId;
    }

}
