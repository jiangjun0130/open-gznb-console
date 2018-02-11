package com.gznb.open.domain.custom;

import com.gznb.open.domain.SystemEncryptWithBLOBs;

/**
 * 系统密钥对扩展实体
 *
 * @author jiangjun
 * @create 2017/11/9
 */
public class SystemEncryptCustom extends SystemEncryptWithBLOBs {

    private String platformNo;

    private String platformName;

    private String merchantNo;

    private String merchantName;

    private String busPlatformNo;

    @Override
    public String toString() {
        return "SystemEncryptCustom{" +
                "platformNo='" + platformNo + '\'' +
                ", platformName='" + platformName + '\'' +
                ", merchantNo='" + merchantNo + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", busPlatformNo='" + busPlatformNo + '\'' +
                '}';
    }

    public String getPlatformNo() {
        return platformNo;
    }

    public void setPlatformNo(String platformNo) {
        this.platformNo = platformNo;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
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

    public String getBusPlatformNo() {
        return busPlatformNo;
    }

    public void setBusPlatformNo(String busPlatformNo) {
        this.busPlatformNo = busPlatformNo;
    }
}
