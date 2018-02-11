package com.gznb.open.domain.custom;

import com.gznb.open.domain.SystemPlatform;

import java.io.Serializable;
import java.util.List;

public class SystemPlatformWithEntry extends SystemPlatform implements Serializable {

    /**
     * 系统平台密钥地址
     */
    private String systemPublicKeyUri;
    /**
     * 系统平台密钥地址test环境
     */
    private String systemPublicKeyUriTest;
    /**
     * 系统平台密钥地址prd环境
     */
    private String systemPublicKeyUriPrd;


    public String getSystemPublicKeyUriTest() {
        return systemPublicKeyUriTest;
    }

    public void setSystemPublicKeyUriTest(String systemPublicKeyUriTest) {
        this.systemPublicKeyUriTest = systemPublicKeyUriTest;
    }

    public String getSystemPublicKeyUriPrd() {
        return systemPublicKeyUriPrd;
    }

    public void setSystemPublicKeyUriPrd(String systemPublicKeyUriPrd) {
        this.systemPublicKeyUriPrd = systemPublicKeyUriPrd;
    }

    /**
     * 商户集合
     */

    private List<BusinessPlatformMerchantCustom> merchants;

    public String getSystemPublicKeyUri() {
        return systemPublicKeyUri;
    }

    public void setSystemPublicKeyUri(String systemPublicKeyUri) {
        this.systemPublicKeyUri = systemPublicKeyUri;
    }

    public List<BusinessPlatformMerchantCustom> getMerchants() {
        return merchants;
    }

    public void setMerchants(List<BusinessPlatformMerchantCustom> merchants) {
        this.merchants = merchants;
    }

    @Override
    public String toString() {
        return "SystemPlatformWithEntry{" +
                "systemPublicKeyUri='" + systemPublicKeyUri + '\'' +
                "systemPublicKeyUriTest='" + systemPublicKeyUriTest + '\'' +
                "systemPublicKeyUriPrd='" + systemPublicKeyUriPrd + '\'' +
                ", merchants=" + merchants +
                '}';
    }
}
