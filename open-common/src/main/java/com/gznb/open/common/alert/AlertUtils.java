package com.gznb.open.common.alert;

import cn.emay.sdk.client.api.Client;
import cn.expopay.mail.client.MailClient;
import com.gznb.open.common.config.AlertEmailConfig;
import com.gznb.open.common.config.AlertSmsConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 告警工具类
 * <p>
 * Created by jj02 on 2017/3/9.
 */
@Component
public class AlertUtils {

    private Logger logger = LoggerFactory.getLogger(AlertUtils.class);

    @Autowired
    private AlertSmsConfig smsConfig;

    @Autowired
    private AlertEmailConfig emailConfig;

    private static Client smsClient = null;

    private static MailClient mailClient = null;

    @PostConstruct
    private void initClient(){
        try {
            smsClient = new Client(smsConfig.getCdKey(), smsConfig.getPassword());
        }catch (Exception e){
            logger.error("初始化发送短信client异常！异常信息：{}",e);
        }
        try {
            mailClient = new MailClient(emailConfig.getHost(),emailConfig.getUserName(),emailConfig.getUserName(),
                    emailConfig.getPassword(),emailConfig.getSenderName(),emailConfig.getRecievers().split(","));
        }catch (Exception e){
            logger.error("初始化发送邮件client异常！异常信息：{}",e);
        }
    }

    /**
     * 发送短信
     *
     * @param content
     * @throws Exception
     */
    public void sendSms(String content) throws Exception {
        try {
            StringBuffer text = new StringBuffer();
            text.append("【智慧生活卡】");
            text.append(content);
            text.append("。具体内容请查看邮件！若未查看到邮件，请在垃圾邮件中查看！");
            smsClient.sendSMS(smsConfig.getRecievers().split(","), text.toString(), "0", 1);
        } catch (Exception e) {
            logger.error("短信发送异常！异常信息:{}", e);
        }
    }

    /**
     * 发送邮件
     *
     * @param title：主题
     * @param content：邮件内容
     * @throws Exception
     */
    public void sendMail(String title, String content) throws Exception {
        try {
            mailClient.send(title,content,true);
        } catch (Exception e) {
            logger.error("邮件发送异常！异常信息：{}", e);
        }
    }

}
