package com.gznb.open.domain.custom;

import com.gznb.open.domain.BusinessPlateformEncryptWithBLOBs;

/**
 * 业务系统密钥对扩展实体
 *
 * @author jiangjun
 * @create 2017/11/7
 */
public class BusinessPlatformEncryptCustom extends BusinessPlateformEncryptWithBLOBs {

    /**
     * 商户编号
     */
    private String merchantNo;

    /**
     * 商户名称
     */
    private String merchantName;

    /**
     * 系统平台编号
     */
    private String platformNo;

    /**
     * 业务系统平台编号
     */
    private String busPlatformNo;

    @Override
    public String toString() {
        return "BusinessPlatformEncryptCustom{" +
                "merchantNo='" + merchantNo + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", platformNo='" + platformNo + '\'' +
                ", busPlatformNo='" + busPlatformNo + '\'' +
                '}';
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getPlatformNo() {
        return platformNo;
    }

    public void setPlatformNo(String platformNo) {
        this.platformNo = platformNo;
    }

    public String getBusPlatformNo() {
        return busPlatformNo;
    }

    public void setBusPlatformNo(String busPlatformNo) {
        this.busPlatformNo = busPlatformNo;
    }
}
