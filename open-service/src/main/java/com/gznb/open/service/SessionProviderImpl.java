package com.gznb.open.service;

import com.gznb.open.common.config.SystemConfig;
import com.gznb.open.common.constants.Constants;
import com.gznb.open.common.constants.ExceptionEnum;
import com.gznb.open.common.exception.RedisException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gznb.redis.cluster.client.RedisClusterTemplate;

/**
 * 远程session接口实现类
 * <p>
 * Created by jj02 on 2017/6/19.
 */
@Service("sessionProvider")
public class SessionProviderImpl implements ISessionProvider {

    @Autowired
    private RedisClusterTemplate redisClusterTemplate;

    @Autowired
    private SystemConfig systemConfig;

    @Override
    public void setSession(String key, String value) {
        try {
            Integer seconds = systemConfig.getSessionExpires() * 60;
            redisClusterTemplate.setData(key + ":" + Constants.USER_SESSION, value,String.class, seconds);
        } catch (Exception e) {
            String extraMsg = "更新redis session异常";
            throw new RedisException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_INTERNAL_SYS_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_INTERNAL_SYS_EXCEPTION.getExceptionMsg(), extraMsg, e);
        }
    }

    @Override
    public String getSession(String key) {
        String redisKey = key + ":" + Constants.USER_SESSION;
        try {
            String userName = redisClusterTemplate.getData(redisKey,String.class);
            if (StringUtils.isNotBlank(userName)) {
                // 更新redis过期时间
                redisClusterTemplate.setExpires(redisKey, systemConfig.getSessionExpires() * 60);
                return userName;
            }
        } catch (Exception e) {
            String extraMsg = "获取redis session异常";
            throw new RedisException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_INTERNAL_SYS_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_INTERNAL_SYS_EXCEPTION.getExceptionMsg(), extraMsg, e);
        }
        return null;
    }

    @Override
    public void removeSession(String key) {
        String redisKey = key + ":" + Constants.USER_SESSION;
        try {
            redisClusterTemplate.delete(redisKey);
        } catch (Exception e) {
            String extraMsg = "删除redis session异常";
            throw new RedisException(ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_INTERNAL_SYS_EXCEPTION.getExceptionCode(),
                    ExceptionEnum.OF_PAY_EXCEPTION_SERIOUS_INTERNAL_SYS_EXCEPTION.getExceptionMsg(), extraMsg, e);
        }
    }
}
