package com.gznb.open.common.exception;

/**
 * 系统严重级别异常
 * 该异常会触发告警逻辑
 *
 * Created by jj02 on 2017/6/15.
 */
public class SystemErrorException extends RuntimeException {

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 错误附加信息
     * 输入参数等信息
     */
    private String extraMsg;

    public SystemErrorException(String errorCode,String errorMsg,String extraMsg){
        super("errorCode: " + errorCode + " ^_^ errorMsg: " + errorMsg + " ^_^ extraMsg: " + extraMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.extraMsg = extraMsg;
    }

    public SystemErrorException(String errorCode,String errorMsg,String extraMsg, Throwable cause){
        super("errorCode: " + errorCode + " ^_^ errorMsg: " + errorMsg + " ^_^ extraMsg: " + extraMsg, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.extraMsg = extraMsg;
    }

    @Override
    public String toString() {
        return "SystemErrorException{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", extraMsg='" + extraMsg + '\'' +
                '}';
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getExtraMsg() {
        return extraMsg;
    }

    public void setExtraMsg(String extraMsg) {
        this.extraMsg = extraMsg;
    }
}
