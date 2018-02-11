package com.gznb.open.domain.vo;

import com.gznb.open.domain.vo.base.BaseQueryVo;

import java.io.Serializable;

/**
 * 应用商户查询实体
 *
 * @author jiangjun
 * @create 2017/11/15
 */
public class BusinessMerchantVo extends BaseQueryVo implements Serializable {

    /**
     * 系统平台编号
     */
    private String platformNo;

    /**
     * 业务系统名称
     */
    private String busPlatformName;

    /**
     * 业务系统编号
     */
    private String busPlatformNo;

    /**
     * 商户名称
     */
    private String merchantName;

    /**
     * 商户编号
     */
    private String merchantNo;
    /**
     * 系统环境标识
     */
    private String envFlag;

    /**
     * 商户状态
     */
    private String merchantStatus;

    @Override
    public String toString() {
        return "BusinessMerchantVo{" +
                "platformNo='" + platformNo + '\'' +
                ", busPlatformName='" + busPlatformName + '\'' +
                ", busPlatformNo='" + busPlatformNo + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", merchantNo='" + merchantNo + '\'' +
                ", envFlag='" + envFlag + '\'' +
                ", merchantStatus='" + merchantStatus + '\'' +
                '}';
    }
    public void setEnvFlag(String envFlag) {
        this.envFlag = envFlag;
    }
    public String getEnvFlag() {
        return envFlag;
    }
    public String getMerchantStatus() {
        return merchantStatus;
    }

    public void setMerchantStatus(String merchantStatus) {
        this.merchantStatus = merchantStatus;
    }

    public String getPlatformNo() {
        return platformNo;
    }

    public void setPlatformNo(String platformNo) {
        this.platformNo = platformNo;
    }

    public String getBusPlatformName() {
        return busPlatformName;
    }

    public void setBusPlatformName(String busPlatformName) {
        this.busPlatformName = busPlatformName;
    }

    public String getBusPlatformNo() {
        return busPlatformNo;
    }

    public void setBusPlatformNo(String busPlatformNo) {
        this.busPlatformNo = busPlatformNo;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }
}
