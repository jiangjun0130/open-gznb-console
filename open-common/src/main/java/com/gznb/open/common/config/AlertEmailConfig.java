package com.gznb.open.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 告警邮件配置
 *
 * Created by jj02 on 2017/3/9.
 */
@Component
@ConfigurationProperties(prefix = "alert.mail")
public class AlertEmailConfig {

    /**
     * 邮件服务器
     */
    private String host;

    /**
     * 发件人邮箱
     */
    private String sender;

    /**
     * 登录账号,一般都是和邮箱名相同
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 发件人姓名
     */
    private String senderName;

    /**
     * 收件人列表的邮箱
     */
    private String recievers;

    @Override
    public String toString() {
        return "AlertEmailConfig{" +
                "host='" + host + '\'' +
                ", sender='" + sender + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", senderName='" + senderName + '\'' +
                ", recievers='" + recievers + '\'' +
                '}';
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getRecievers() {
        return recievers;
    }

    public void setRecievers(String recievers) {
        this.recievers = recievers;
    }
}
