package com.gznb.open.core.utils;

import javax.servlet.http.HttpServletRequest;

/**
 *  获取代理IP
 *
 * Created by jj02 on 2017/4/28.
 */
public class IPUtils {

    /**
     * 获取ip代理地址
     *
     * @param request
     * @return
     */
    public static String getProxyIP(HttpServletRequest request) {
        String fromSource = "X-Real-IP";
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
            fromSource = "X-Forwarded-For";
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            fromSource = "Proxy-Client-IP";
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            fromSource = "WL-Proxy-Client-IP";
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            fromSource = "request.getRemoteAddr";
        }
        String ipInfo = "Client IP: " + ip + ", fromSource: " + fromSource;
        return ipInfo;
    }
}
