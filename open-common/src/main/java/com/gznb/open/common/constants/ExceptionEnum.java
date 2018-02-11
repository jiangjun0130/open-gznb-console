package com.gznb.open.common.constants;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 欧飞渠道缴费严重异常字典
 * <p>
 * Created by jj02 on 2017/3/9.
 */
public enum ExceptionEnum {

    /**
     * 系统内部定义异常
     */
    OF_PAY_EXCEPTION_SERIOUS_INTERNAL_SYS_EXCEPTION("999995", "系统内部异常"),
    OF_PAY_EXCEPTION_SERIOUS_BUSINESS_SYS_NIO_EXCEPTION("999996", "调用业务系统接口异常"),
    OF_PAY_EXCEPTION_SERIOUS_PAY_CHANNEL_NIO_EXCEPTION("999997", "调用支付渠道商接口异常"),
    OF_PAY_EXCEPTION_SERIOUS_SQL_EXCEPTION("999998", "Dao层异常"),
    OF_PAY_EXCEPTION_SERIOUS_EXCEPTION("999999", "系统异常");

    /**
     * 异常码
     */
    private String exceptionCode;

    /**
     * 异常信息
     */
    private String exceptionMsg;

    ExceptionEnum(String exceptionCode, String exceptionMsg) {
        this.exceptionCode = exceptionCode;
        this.exceptionMsg = exceptionMsg;
    }

    public  static Map<String, ExceptionEnum> exceptionMap;

    static {
        exceptionMap = new HashMap<>();
        for (ExceptionEnum item : ExceptionEnum.values()) {
            exceptionMap.put(item.getExceptionCode(), item);
        }
    }

    public static ExceptionEnum getException(String exceptionCode) {
        if (StringUtils.isBlank(exceptionCode) || !exceptionMap.containsKey(exceptionCode)) {
            return null;
        }
        return exceptionMap.get(exceptionCode);
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }
}
