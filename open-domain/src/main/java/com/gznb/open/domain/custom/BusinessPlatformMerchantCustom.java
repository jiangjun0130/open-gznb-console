package com.gznb.open.domain.custom;

import com.gznb.open.domain.BusinessPlatformMerchant;
import com.gznb.open.domain.vo.base.PageBean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kl09 on 2017/7/13.
 */
public class BusinessPlatformMerchantCustom extends BusinessPlatformMerchant implements Serializable {

    /**
     * 系统平台名称
     */
    private String platformName;

    /**
     * 业务系统名称
     */
    private String busPlatformName;

    /**
     * 商户状态名称
     */
    private String merchantStatusName;

    /**
     * 业务系统商户私钥地址
     */
    private String busPrivateKeyUri;
    /**
     * 业务系统商户私钥地址test环境
     */
    private String busPrivateKeyUriTest;
    /**
     * 业务系统商户私钥地址prd环境
     */
    private String busPrivateKeyUriPrd;
    /**
     * 业务系统商户公钥地址
     */
    private String busPublicKeyUri;

    /**
     * 业务系统商户公钥地址test环境
     */
    private String busPublicKeyUriTest;
    /**
     * 业务系统商户公钥地址prd环境
     */
    private String busPublicKeyUriPrd;
    /**
     * 业务平台私钥地址test环境
     */
    private String systemPrivateKeyUriTest;
    /**
     * 业务平台私钥地址prd环境
     */
    private String systemPrivateKeyUriPrd;

    /**
     * 渠道集合、带分页信息
     */
    private PageBean channels;

    @Override
    public String toString() {
        return "BusinessPlatformMerchantCustom{" +
                "platformName='" + platformName + '\'' +
                ", busPlatformName='" + busPlatformName + '\'' +
                ", merchantStatusName='" + merchantStatusName + '\'' +
                ", busPrivateKeyUri='" + busPrivateKeyUri + '\'' +
                ", busPrivateKeyUriTest='" + busPrivateKeyUriTest + '\'' +
                ", busPrivateKeyUriPrd='" + busPrivateKeyUriPrd + '\'' +
                ", busPublicKeyUri='" + busPublicKeyUri + '\'' +
                ", busPublicKeyUriTest='" + busPublicKeyUriTest + '\'' +
                ", busPublicKeyUriPrd='" + busPublicKeyUriPrd + '\'' +
                ", systemPrivateKeyUriTest='" + systemPrivateKeyUriTest + '\'' +
                ", systemPrivateKeyUriPrd='" + systemPrivateKeyUriPrd + '\'' +
                ", channels=" + channels +
                '}';
    }

    public String getBusPrivateKeyUriTest() {
        return busPrivateKeyUriTest;
    }

    public void setBusPrivateKeyUriTest(String busPrivateKeyUriTest) {
        this.busPrivateKeyUriTest = busPrivateKeyUriTest;
    }

    public String getBusPrivateKeyUriPrd() {
        return busPrivateKeyUriPrd;
    }

    public void setBusPrivateKeyUriPrd(String busPrivateKeyUriPrd) {
        this.busPrivateKeyUriPrd = busPrivateKeyUriPrd;
    }

    public String getBusPublicKeyUriTest() {
        return busPublicKeyUriTest;
    }

    public void setBusPublicKeyUriTest(String busPublicKeyUriTest) {
        this.busPublicKeyUriTest = busPublicKeyUriTest;
    }

    public String getBusPublicKeyUriPrd() {
        return busPublicKeyUriPrd;
    }

    public void setBusPublicKeyUriPrd(String busPublicKeyUriPrd) {
        this.busPublicKeyUriPrd = busPublicKeyUriPrd;
    }

    public String getSystemPrivateKeyUriTest() {
        return systemPrivateKeyUriTest;
    }

    public void setSystemPrivateKeyUriTest(String systemPrivateKeyUriTest) {
        this.systemPrivateKeyUriTest = systemPrivateKeyUriTest;
    }

    public String getSystemPrivateKeyUriPrd() {
        return systemPrivateKeyUriPrd;
    }

    public void setSystemPrivateKeyUriPrd(String systemPrivateKeyUriPrd) {
        this.systemPrivateKeyUriPrd = systemPrivateKeyUriPrd;
    }

    public String getBusPublicKeyUri() {
        return busPublicKeyUri;
    }

    public void setBusPublicKeyUri(String busPublicKeyUri) {
        this.busPublicKeyUri = busPublicKeyUri;
    }

    public String getMerchantStatusName() {
        return merchantStatusName;
    }

    public void setMerchantStatusName(String merchantStatusName) {
        this.merchantStatusName = merchantStatusName;
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

    public String getBusPrivateKeyUri() {
        return busPrivateKeyUri;
    }

    public void setBusPrivateKeyUri(String busPrivateKeyUri) {
        this.busPrivateKeyUri = busPrivateKeyUri;
    }

    public PageBean getChannels() {
        return channels;
    }

    public void setChannels(PageBean channels) {
        this.channels = channels;
    }
}
