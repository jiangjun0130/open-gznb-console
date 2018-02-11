package com.gznb.open.core.interceptor;

import com.gznb.open.common.config.SystemConfig;
import com.gznb.open.core.utils.RequestUtils;
import com.gznb.open.service.ISessionProvider;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证登录拦截器
 *
 * Created by jj02 on 2017/6/20.
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter{

    @Autowired
    private ISessionProvider sessionProvider;

//    @Autowired
//    private SystemConfig systemConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUri = request.getRequestURI();
        // 不执行登录拦截的url
        /*if(!CollectionUtils.isEmpty(systemConfig.getNonLoginUrls())){
            for (String nonLoginUrl : systemConfig.getNonLoginUrls()){
                if(requestUri.contains(nonLoginUrl)){
                    return true;
                }
            }
        }*/
        String csessionid = RequestUtils.getCSESSIONID(request, response);
        String userName = sessionProvider.getSession(csessionid);
        if (StringUtils.isNotBlank(userName)) {
            // 身份信息存在，放行
            return true;
        }
        // 执行到此处表示用户身份需要认证，跳转到登录页面
        request.getRequestDispatcher("/toLoginUI")
                .forward(request,response);
        return false;
    }
}
