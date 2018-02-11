package com.gznb.open.common.alert;

import cn.emay.slf4j.Logger;
import cn.emay.slf4j.LoggerFactory;
import com.gznb.open.common.config.SystemConfig;
import com.gznb.open.common.constants.CacheKeyConstants;
import com.gznb.open.common.constants.Constants;
import com.gznb.open.common.exception.SystemErrorException;
import com.gznb.open.common.utils.IPUtils;
import com.gznb.redis.cluster.client.RedisClusterTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 异常池处理工具类
 * <p>
 * Created by jj02 on 2017/3/9.
 */
@Component
public class ExceptionPoolExecutorUtils {

    private final Logger logger = LoggerFactory.getLogger(ExceptionPoolExecutorUtils.class);

    @Autowired
    private AlertUtils alertUtils;

    @Autowired
    private SystemConfig systemConfig;

    @Autowired
    private RedisClusterTemplate redisClusterTemplate;

    /**
     * 将异常存放到异常池中
     *
     * @param exception
     */
    public void push2ExceptionMap(SystemErrorException exception) {
        String exceptionCount = ""; // 异常次数
        try {
            exceptionCount = redisClusterTemplate.getHashData(CacheKeyConstants.REDIS_EXCEPTION_MAP, exception.getErrorCode(), String.class);
        } catch (Exception e) {
            logger.error("获取异常缓存信息异常！异常信息：" + e);
            return;
        }
        try {
            if (StringUtils.isBlank(exceptionCount)) {
                // 将新类型的异常放到异常池中，并初始化异常次数为1
                redisClusterTemplate.setHashData(CacheKeyConstants.REDIS_EXCEPTION_MAP, exception.getErrorCode(), "1", String.class);
                logger.warn("发生严重类型异常，触发告警流程！");
                alertUtils.sendSms("【开放平台出现异常】" + exception.getErrorMsg());
                alertUtils.sendMail("【开放平台出现异常】", generateMailContent(exception));
                return;
            }
            Integer count = Integer.valueOf(exceptionCount);
            if (count < systemConfig.getExceptionCount()) {
                // 异常发生次数，未达到告警次数级别
                logger.warn("发生类型异常次数未超出限制次数，不触发告警流程！发生异常次数：{}", count);
                Integer totalCount = ++count;
                redisClusterTemplate.setHashData(CacheKeyConstants.REDIS_EXCEPTION_MAP, exception.getErrorCode(), totalCount.toString(), String.class);
            } else {
                logger.warn("发生类型异常次数超出限制次数，触发告警流程！发生异常次数：{}", count);
                // 异常发生次数，达到告警次数级别
                alertUtils.sendSms("【开放平台出现异常】" + exception.getErrorMsg());
                alertUtils.sendMail("【开放平台出现异常】", generateMailContent(exception));
                // 重置异常发生次数
                redisClusterTemplate.setHashData(CacheKeyConstants.REDIS_EXCEPTION_MAP, exception.getErrorCode(), "0", String.class);
            }
        } catch (Exception e) {
            logger.error("告警池处理出现异常！", e);
        }
    }

    /**
     * 组装邮件发送内容
     *
     * @param exception
     * @return
     */
    private String generateMailContent(SystemErrorException exception) {
        StringBuilder sb = new StringBuilder();
        sb.append("异常系统: ").append(Constants.NEW_LINE)
                .append(CacheKeyConstants.PN_NAME).append(Constants.NEW_LINE).append(Constants.NEW_LINE)
                .append("异常类信息: ").append(Constants.NEW_LINE)
                .append(exception.getClass().getSimpleName()).append(Constants.NEW_LINE).append(Constants.NEW_LINE)
                .append("错误码: ").append(Constants.NEW_LINE)
                .append(exception.getErrorCode()).append(Constants.NEW_LINE).append(Constants.NEW_LINE)
                .append("错误信息: ").append(Constants.NEW_LINE)
                .append(exception.getErrorMsg()).append(Constants.NEW_LINE).append(Constants.NEW_LINE)
                .append("附加信息: ").append(Constants.NEW_LINE)
                .append(exception.getExtraMsg()).append(Constants.NEW_LINE).append(Constants.NEW_LINE)
                .append("发送邮件服务器IP：").append(Constants.NEW_LINE)
                .append(IPUtils.getIp()).append(Constants.NEW_LINE).append(Constants.NEW_LINE)
                .append("异常详细信息：").append(Constants.NEW_LINE)
                .append(exception.getCause());
        return sb.toString();
    }
}
