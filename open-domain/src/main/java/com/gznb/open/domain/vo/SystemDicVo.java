package com.gznb.open.domain.vo;

import com.gznb.open.domain.vo.base.BaseQueryVo;

import java.io.Serializable;

/**
 * Created by zhenglin on 2017/8/1.
 */
public class SystemDicVo extends BaseQueryVo implements Serializable {
    private Integer dicdataId;
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
    /**
     *创建人
     */
    private String userName;

    public Integer getDicdataId() {
        return dicdataId;
    }

    public void setDicdataId(Integer dicdataId) {
        this.dicdataId = dicdataId;
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

    public String getDicStatus() {
        return dicStatus;
    }

    public void setDicStatus(String dicStatus) {
        this.dicStatus = dicStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
