package com.gznb.open.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *  告警短信配置
 *
 * Created by jj02 on 2017/3/9.
 */
@Component
@ConfigurationProperties(prefix = "alert.sms")
public class AlertSmsConfig {

    private String cdKey;

    private String password;

    private String recievers;

    @Override
    public String toString() {
        return "AlertConfig{" +
                "cdKey='" + cdKey + '\'' +
                ", password='" + password + '\'' +
                ", recievers='" + recievers + '\'' +
                '}';
    }

    public String getCdKey() {
        return cdKey;
    }

    public void setCdKey(String cdKey) {
        this.cdKey = cdKey;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRecievers() {
        return recievers;
    }

    public void setRecievers(String recievers) {
        this.recievers = recievers;
    }
}
