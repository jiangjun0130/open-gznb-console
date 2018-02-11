package com.gznb.open.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统参数配置
 *
 * Created by jj02 on 2017/3/9.
 */
@Component
@ConfigurationProperties(prefix = "systemConfig")
public class SystemConfig {

    /**
     * 发生异常次数限制，达到限制之后触发告警逻辑
     */
    private Integer exceptionCount;

    /**
     * 系统版本
     */
    private String systemVersion;

    /**
     * 系统运行环境标识。默认为空，则标识生产环境。1：dev环境；2：test环境；3：pre环境；4：prd环境
     */
    private String  envFlag;

    /**
     * session保存时间
     */
    private Integer sessionExpires;

    /**
     * 图片服务器地址
     */
    private String imageUrl;

    /**
     * 登录地址
     */
    private String loginUrl;

    /**
     * 不需进行登录地址
     */
    private List<String> nonLoginUrls;

    public List<String> getNonLoginUrls() {
        return nonLoginUrls;
    }

    public void setNonLoginUrls(List<String> nonLoginUrls) {
        this.nonLoginUrls = nonLoginUrls;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public Integer getExceptionCount() {
        return exceptionCount;
    }

    public void setExceptionCount(Integer exceptionCount) {
        this.exceptionCount = exceptionCount;
    }

    public String getEnvFlag() {
        return envFlag;
    }

    public void setEnvFlag(String envFlag) {
        this.envFlag = envFlag;
    }

    public Integer getSessionExpires() {
        return sessionExpires;
    }

    public void setSessionExpires(Integer sessionExpires) {
        this.sessionExpires = sessionExpires;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }
}
