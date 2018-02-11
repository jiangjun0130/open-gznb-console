package com.gznb.open.domain.custom;

import com.gznb.open.domain.SystemInterface;
import com.gznb.open.domain.SystemInterfaceWithBLOBs;

import java.io.Serializable;

/**
 * Created by jj02 on 2017/6/29.
 */
public class SystemInterfaceCustom extends SystemInterfaceWithBLOBs implements Serializable{

    /**
     * 平台名称
     */
    private String platformName;

    /**
     * 测试环境地址
     */
    private String testUrl;

    /**
     * pre环境地址
     */
    private String preUrl;

    /**
     * prd环境地址
     */
    private String prdUrl;

    /**
     * 模块名称
     */
    private String moduleName;

    /**
     * 模块路径
     */
    private String moduleUrl;

    /**
     * 状态名称
     */
    private String statusName;

    /**
     * 接口请求方式名称
     */
    private String requestModeName;

    /**
     * 接口请求参数类型
     */
    private String paramFormat;

    /**
     * 接口返回参数类型
     */
    private String responseFormatName;

    /**
     * 请求参数包装类型名称
     */
    private String reqWrapperName;

    /**
     * 响应参数包装类型名称
     */
    private String respWrapperName;

    /**
     * 平台备注信息
     */
    private String platformNote;

    public String getPlatformNote() {
        return platformNote;
    }

    public void setPlatformNote(String platformNote) {
        this.platformNote = platformNote;
    }

    public String getTestUrl() {
        return testUrl;
    }

    public void setTestUrl(String testUrl) {
        this.testUrl = testUrl;
    }

    public String getPreUrl() {
        return preUrl;
    }

    public void setPreUrl(String preUrl) {
        this.preUrl = preUrl;
    }

    public String getPrdUrl() {
        return prdUrl;
    }

    public void setPrdUrl(String prdUrl) {
        this.prdUrl = prdUrl;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getRequestModeName() {
        return requestModeName;
    }

    public void setRequestModeName(String requestModeName) {
        this.requestModeName = requestModeName;
    }

    public String getParamFormat() {
        return paramFormat;
    }

    public void setParamFormat(String paramFormat) {
        this.paramFormat = paramFormat;
    }

    public String getModuleUrl() {
        return moduleUrl;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }

    public String getResponseFormatName() {
        return responseFormatName;
    }

    public void setResponseFormatName(String responseFormatName) {
        this.responseFormatName = responseFormatName;
    }

    public String getReqWrapperName() {
        return reqWrapperName;
    }

    public void setReqWrapperName(String reqWrapperName) {
        this.reqWrapperName = reqWrapperName;
    }

    public String getRespWrapperName() {
        return respWrapperName;
    }

    public void setRespWrapperName(String respWrapperName) {
        this.respWrapperName = respWrapperName;
    }
}
