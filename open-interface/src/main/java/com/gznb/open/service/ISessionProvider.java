package com.gznb.open.service;

import java.util.List;

/**
 * 远程session接口
 *
 * Created by jj02 on 2017/6/19.
 */
public interface ISessionProvider {

    /**
     * 保存用户信息到session
     * @param key
     * @param value
     */
    void setSession(String key, String value);

    /**
     * 获取用户信息
     * @param key
     * @return
     */
    String getSession(String key);

    /**
     * 清除session
     * @param key
     */
    void removeSession(String key);
}
