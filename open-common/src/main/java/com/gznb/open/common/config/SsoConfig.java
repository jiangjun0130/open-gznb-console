package com.gznb.open.common.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * SSO配置
 *
 * Created by jj02 on 2017/6/19.
 */
@Component
@ConfigurationProperties(prefix = "sso")
@ConditionalOnProperty(name = "open.gznb.module",havingValue = "portal",matchIfMissing = false)
public class SsoConfig {

    /**
     * 客户端id
     */
    private String clientId;

    /**
     * 客户端密码
     */
    private String clientSecret;

    /**
     * sso登录地址
     */
    private String loginUri;

    /**
     * 回调地址
     */
    private String callbackUri;

    @Override
    public String toString() {
        return "SsoConfig{" +
                "clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", loginUri='" + loginUri + '\'' +
                ", callbackUri='" + callbackUri + '\'' +
                '}';
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getLoginUri() {
        return loginUri;
    }

    public void setLoginUri(String loginUri) {
        this.loginUri = loginUri;
    }

    public String getCallbackUri() {
        return callbackUri;
    }

    public void setCallbackUri(String callbackUri) {
        this.callbackUri = callbackUri;
    }
}
