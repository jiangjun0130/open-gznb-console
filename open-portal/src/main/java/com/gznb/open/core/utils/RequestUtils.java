package com.gznb.open.core.utils;

import com.gznb.open.common.constants.Constants;
import com.gznb.open.common.utils.UUIDUtils;
import org.apache.commons.lang3.StringUtils;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 处理request生成clientid
 *
 * Created by jj02 on 2017/6/19.
 */
public class RequestUtils {

    /**
     * 设置自定义客户端sessionid
     * @param request
     * @param response
     * @return
     */
    public static String getCSESSIONID(HttpServletRequest request, HttpServletResponse response){
        // 1：获取cookie
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            // 2：从cookie中获取csessionid
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(Constants.CSESSIONID)){
                    // 3：如果有直接使用
                    return cookie.getValue();
                }
            }
        }
        // 4：如果没有csessionid，则创建并保存到cookie中写回到浏览器
        String csessionid = UUIDUtils.getUUID();
        // 设置cookie
        Cookie cookie = new Cookie(Constants.CSESSIONID,csessionid);
        // 设置路径
        cookie.setPath("/");
        // 设置cookie有效期 -1：关闭浏览器销毁 0：立即失效 >0：到时间才消失
        cookie.setMaxAge(-1);
        //cookie.setMaxAge(60 * 30);
        response.addCookie(cookie);
        return csessionid;
    }

    /**
     * 设置登录用户信息到cookie
     * @param request
     * @param response
     * @param userName
     * @param userType
     */
    public static void setCUserInfo(HttpServletRequest request, HttpServletResponse response, String userName, String userType){
        if(StringUtils.isNotBlank(userName)) {
            isExistsCookie(request, response, Constants.CUSERNAME, userName);
        }
        if(StringUtils.isNotBlank(userType)) {
            isExistsCookie(request, response, Constants.CUSERTYPE, userType);
        }
    }

    /**
     * 判断是否存在相应的cookie并更新cookie值
     * @param request
     * @param response
     * @param key
     * @param value
     */
    private static void isExistsCookie(HttpServletRequest request, HttpServletResponse response,String key,String value){
        // 1：获取cookie
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            // 2：从cookie中获取csessionid
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(key)){
                    // 3：如果有，并且值不相同，则更新
                    if(!cookie.getValue().equals(value)){
                        cookie.setValue(value);
                        response.addCookie(cookie);
                        return;
                    }
                }
            }
        }
        // 4：如果没有csessionid，则创建并保存到cookie中写回到浏览器
        // 设置cookie
        Cookie cookie = new Cookie(key,value);
        // 设置路径
        cookie.setPath("/");
        // 设置cookie有效期 -1：关闭浏览器销毁 0：立即失效 >0：到时间才消失
        // cookie.setMaxAge(60 * 30);
        cookie.setMaxAge(-1);
        response.addCookie(cookie);
    }

}
