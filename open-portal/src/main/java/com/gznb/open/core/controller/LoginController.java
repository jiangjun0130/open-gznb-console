package com.gznb.open.core.controller;

import com.gznb.open.common.config.PortalConfig;
import com.gznb.open.common.config.SsoConfig;
import com.gznb.open.common.config.SystemConfig;
import com.gznb.open.common.constants.Constants;
import com.gznb.open.core.controller.base.AbstractController;
import com.gznb.open.core.utils.RequestUtils;
import com.gznb.open.domain.manual.DataCenter;
import com.gznb.open.service.ISessionProvider;
import com.gznb.open.service.ISystemUserService;
import com.gznb.ssoclient.api.IUser;
import com.gznb.ssoclient.api.SSOClientAPI;
import com.gznb.ssoclient.api.SSOClientConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jj02 on 2017/6/19.
 */
@RestController
public class LoginController extends AbstractController<LoginController> {

    @Autowired
    private SsoConfig ssoConfig;

    @Autowired
    private SystemConfig systemConfig;

    @Autowired
    private PortalConfig portalConfig;

    @Autowired
    private ISessionProvider sessionProvider;

    @Autowired
    private ISystemUserService iSystemUserService;

    @PostConstruct
    public void init() {
        initSsoConfig();
    }

    /**
     * 初始化sso配置
     */
    private void initSsoConfig() {
        SSOClientConfig ssoClientConfig = new SSOClientConfig();
        ssoClientConfig.setClientId(ssoConfig.getClientId());
        ssoClientConfig.setClientSecret(ssoConfig.getClientSecret());
        ssoClientConfig.setLoginHostUri(ssoConfig.getLoginUri());
        SSOClientAPI.getInstance().init(ssoClientConfig);
    }

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        return "index";
    }

    /**
     * 转向登录页面
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/toLoginUI")
    public DataCenter toLoginUI(HttpServletRequest request, HttpServletResponse response) {
        DataCenter responseData = new DataCenter();
        responseData.setFlag(Constants.EXECUTE_LOGIN);
        responseData.setMessage(systemConfig.getLoginUrl());
        return responseData;
    }

    /**
     * 登录
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        String csessionid = RequestUtils.getCSESSIONID(request, response);
        String userName = sessionProvider.getSession(csessionid);
        if (StringUtils.isBlank(userName)) {
            //response.setHeader("Access-Control-Allow-Origin","http://10.66.19.72:8080");
            return new ModelAndView("redirect:" + SSOClientAPI.getInstance().loginUri(ssoConfig.getCallbackUri(), "this is a state"));
            //return new ModelAndView("redirect:index");
        }
        // 登录成功
        return new ModelAndView("redirect:" + portalConfig.getIndexUri());
    }

    /**
     * 判断用户是否登录
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/isLogin")
    public boolean isLogin(HttpServletRequest request, HttpServletResponse response) {
        boolean result = false;
        String userName = sessionProvider.getSession(RequestUtils.getCSESSIONID(request, response));
        if (StringUtils.isNotBlank(userName)) {
            result = true;
        }
        return result;
    }

    /**
     * 退出登录
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/logout")
    public DataCenter logout(HttpServletRequest request, HttpServletResponse response) {
        String csessionid = RequestUtils.getCSESSIONID(request, response);
        sessionProvider.removeSession(csessionid);
        DataCenter responseData = new DataCenter();
        responseData.setFlag(Constants.EXECUTE_OK);
        responseData.setMessage("退出开放平台成功！");
        return responseData;
    }

    /**
     * 单点登录成功后回调
     *
     * @param code
     * @param state
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/callback")
    public ModelAndView callback(String code, String state, HttpServletRequest request, HttpServletResponse response) {
        IUser user = null;//通过code获取用户信息
        String userName = "";
        try {
            user = SSOClientAPI.getInstance().getUser(code);
            String csessionid = RequestUtils.getCSESSIONID(request, response);
            logger.info("csessionid:{}", csessionid);
            userName = user.getEmail();

            //根据用户名查询用户角色，添加到session中并返回给前台
            List<String> list = iSystemUserService.queryTypeByuserName(userName);
            StringBuilder struserType = new StringBuilder();
            if (!CollectionUtils.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    struserType.append(list.get(i) + "#");
                }
                String userType = struserType.substring(0, struserType.length() - 1);
                RequestUtils.setCUserInfo(request, response, userName, userType);
            }
            ;
            sessionProvider.setSession(csessionid, userName);
            RequestUtils.setCUserInfo(request, response, userName, null);

        } catch (Exception e) {
            logger.error("callback异常！异常信息：" + e);
        }
        // 登录成功
        return new ModelAndView("redirect:" + portalConfig.getIndexUri());
    }
}