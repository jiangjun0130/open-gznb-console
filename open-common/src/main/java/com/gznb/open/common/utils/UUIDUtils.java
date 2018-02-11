package com.gznb.open.common.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Created by JJ on 2016/7/14.
 */
public class UUIDUtils {

    /**
     * 获取UUID字符串
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 带分隔符
     *
     * @return
     */
    public static String getUUIDWithSplit() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        System.out.println(getUUID());
    }

    /**
     * 根据当前时间生成标识
     *
     * @return 格式为：yyyyMMddHHmmssSSS
     */
    public static synchronized String getBusinessNum() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(dateTimeFormatter);
        return format.substring(2, format.length());
    }
}
