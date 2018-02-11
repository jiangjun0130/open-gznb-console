package com.gznb.open.domain.custom;

import com.gznb.open.domain.BusinessPlatformChannelWithBLOBs;

import java.io.Serializable;

/**
 * 渠道扩展实体
 *
 * @author jj02 jiangjun
 * @create 2017/11/15
 */
public class BusinessPlatformChannelCustom extends BusinessPlatformChannelWithBLOBs implements Serializable {

    /**
     * 系统平台编号
     */
    private String platformNo;

    /**
     * 系统平台名称
     */
    private String platformName;

    /**
     * 业务系统平台名称
     */
    private String busPlatformName;

    /**
     * 业务系统平台编号
     */
    private String busPlatformNo;

    /**
     * 商户名称
     */
    private String busMerchantName;

    /**
     * 渠道状态名称
     */
    private String channelStatusName;

    /**
     * 证书文件名称
     */
    private String certFileName;

    @Override
    public String toString() {
        return "BusinessPlatformChannelCustom{" +
                "platformNo='" + platformNo + '\'' +
                ", platformName='" + platformName + '\'' +
                ", busPlatformName='" + busPlatformName + '\'' +
                ", busPlatformNo='" + busPlatformNo + '\'' +
                ", busMerchantName='" + busMerchantName + '\'' +
                ", channelStatusName='" + channelStatusName + '\'' +
                ", certFileName='" + certFileName + '\'' +
                '}';
    }

    public String getChannelStatusName() {
        return channelStatusName;
    }

    public void setChannelStatusName(String channelStatusName) {
        this.channelStatusName = channelStatusName;
    }

    public String getBusMerchantName() {
        return busMerchantName;
    }

    public void setBusMerchantName(String busMerchantName) {
        this.busMerchantName = busMerchantName;
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

    public String getCertFileName() {
        return certFileName;
    }

    public void setCertFileName(String certFileName) {
        this.certFileName = certFileName;
    }
}
