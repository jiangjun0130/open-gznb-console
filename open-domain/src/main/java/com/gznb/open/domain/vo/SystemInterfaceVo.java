package com.gznb.open.domain.vo;

import com.gznb.open.domain.vo.base.BaseQueryVo;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Created by jj02 on 2017/6/28.
 */
public class SystemInterfaceVo extends BaseQueryVo implements Serializable {

    /**
     * 系统平台id
     */
    @Min(value = 1, message = "系统平台标识无效！")
    private Integer platformId;

    /**
     * 模块标识
     */
    @Min(value = 1, message = "系统模块标识无效！")
    private Integer moduleId;

    /**
     * 接口标识
     */
    private Integer interfaceId;

    /**
     * 模块名称
     */
    @NotBlank(message = "系统接口名称不能为空！")
    private String name;

    /**
     * 模块路径
     */
/*    @NotBlank(message = "系统接口路径不能为空！")*/
    private String path;

    /**
     * 状态
     */
    private String status;

    /**
     * 系统模块描述
     */
    @NotBlank(message = "系统接口描述不能为空！")
    private String description;

    private String note;

    /**
     * 接口版本
     */
    @NotBlank(message = "系统接口版本不能为空！")
    private String version;

    /**
     * 接口请求签名规则
     */
    private String reqRule;

    /**
     * 接口响应签名规则说明
     */
    private String reqRuleDesc;

    /**
     * 接口响应签名规则
     */
    private String respRule;

    /**
     * 接口请求签名规则说明
     */
    private String respRuleDesc;

    /**
     * 请求方式
     */
    @NotBlank(message = "系统接口请求方式不能为空！")
    private String method;

    /**
     * 参数包装类型
     */
    @NotBlank(message = "接口请求参数包装类型不能为空！")
    private String reqWrapperType;

    /**
     * 参数包装类型
     */
    @NotBlank(message = "接口响应参数包装类型不能为空！")
    private String respWrapperType;

    /**
     * 请求参数格式
     */
    @NotBlank(message = "系统接口请求参数格式不能为空！")
    private String paramFormat;

    /**
     * 请求响应格式
     */
    @NotBlank(message = "系统接口返回数据格式不能为空！")
    private String responseFormat;

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Integer interfaceId) {
        this.interfaceId = interfaceId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getReqRule() {
        return reqRule;
    }

    public void setReqRule(String reqRule) {
        this.reqRule = reqRule;
    }

    public String getReqRuleDesc() {
        return reqRuleDesc;
    }

    public void setReqRuleDesc(String reqRuleDesc) {
        this.reqRuleDesc = reqRuleDesc;
    }

    public String getRespRule() {
        return respRule;
    }

    public void setRespRule(String respRule) {
        this.respRule = respRule;
    }

    public String getRespRuleDesc() {
        return respRuleDesc;
    }

    public void setRespRuleDesc(String respRuleDesc) {
        this.respRuleDesc = respRuleDesc;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParamFormat() {
        return paramFormat;
    }

    public void setParamFormat(String paramFormat) {
        this.paramFormat = paramFormat;
    }

    public String getResponseFormat() {
        return responseFormat;
    }

    public void setResponseFormat(String responseFormat) {
        this.responseFormat = responseFormat;
    }

    public String getReqWrapperType() {
        return reqWrapperType;
    }

    public void setReqWrapperType(String reqWrapperType) {
        this.reqWrapperType = reqWrapperType;
    }

    public String getRespWrapperType() {
        return respWrapperType;
    }

    public void setRespWrapperType(String respWrapperType) {
        this.respWrapperType = respWrapperType;
    }
}
