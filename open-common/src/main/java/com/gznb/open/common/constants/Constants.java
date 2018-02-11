package com.gznb.open.common.constants;

import java.text.SimpleDateFormat;

/**
 * 常量工具类
 * <p>
 * Created by jj02 on 2017/1/18.
 */
public class Constants {

    public static final String CHARSET_UTF8 = "UTF-8";

    public static final String NEW_LINE = "\r\n";

    //============================= 操作结果标识 ==========================================
    /**
     * 操作成功
     */
    public static final int EXECUTE_OK = 1;

    /**
     * 操作失败
     */
    public static final int EXECUTE_ERROR = 0;

    /**
     * 执行登录操作标识
     */
    public static final int EXECUTE_LOGIN = -1;

    /**
     * 系统数据状态:正常
     */
    public static final String SYSTEM_DATA_STATUS_NORMAL = "1";

    /**
     * 系统数据状态:禁用
     */
    public static final String SYSTEM_DATA_STATUS_DISABLE = "2";

    /**
     * 系统数据状态:删除
     */
    public static final String SYSTEM_DATA_STATUS_DELETE = "3";

    public static final String USER_SESSION = "USER_SESSION";

    /**
     * 自定义客户端sessionid
     */
    public static final String CSESSIONID = "CSESSIONID";

    /**
     * 自定义cession username
     */
    public static final String CUSERNAME = "CUSERNAME";

    /**
     * 自定义cession usertype
     */
    public static final String CUSERTYPE = "CUSERTYPE";
    /**
     * 申请审核通过
     */
    public static final String AUDIT_RESULT_OK = "1";
    /**
     * 申请审核不通过
     */
    public static final String AUDIT_RESULT_ERROR = "2";
    /**
     * 申请状态：初始申请
     */
    public static final int APPLY_STATUS_INIT = 2;
    /**
     * 申请状态：审核完成
     */
    public static final int APPLY_STATUS_DOWN = 3;

    /**
     * 业务系统状态：正常
     */
    public static final String BUSSYSTEM_STATUS_NORMAL = "1";

    /**
     * 业务系统状态：禁用
     */
    public static final String BUSSYSTEM_STATUS_DISABLE = "2";
    /**
     * 业务系统状态：删除
     */
    public static final String BUSSYSTEM_STATUS_DELETED = "3";
    /**
     * 商户状态：正常
     */
    public static final String MERCHANT_STATUS_NORMAL = "1";
    /**
     * 商户状态：禁用
     */
    public static final String MERCHANT_STATUS_DISABLE = "2";
    /**
     * 商户状态：删除
     */
    public static final String MERCHANT_STATUS_DELETED = "3";
    /**
     * 加密类型RSA
     */
    public static final String ENCRYPT_TYPE_RSA = "1";
    /**
     * 加密类型AES
     */
    public static final String ENCRYPT_TYPE_AES = "2";
    /**
     * MD5
     */
    public static final String ENCRYPT_TYPE_MD5 = "3";
    /**
     * 密钥状态：正常
     */
    public static final String ENCRYPT_STATUS_NORMAL = "1";

    /**
     * 密钥状态：禁用
     */
    public static final String ENCRYPT_STATUS_DISABLE = "2";
    /**
     * 密钥状态：删除
     */
    public static final String ENCRYPT_STATUS_DELETED = "3";
    /**
     * rsakey length
     */
    public static final int RSA_KEY_LENGTH = 2048;
    /**
     * 日期格式
     */
    public static final String DFS_DAY = "yyyyMMdd";
    public static final SimpleDateFormat DAY_FORMAT = new SimpleDateFormat(DFS_DAY);

    /**
     * 业务系统编号前缀
     */
    public static final String BUS_PLATFORM_PREFIX = "BUS_";

    /**
     * 系统平台编号前缀
     */
    public static final String SYSTEM_PLATFORM_PREFIX = "SYS_";

    /**
     * 商户编号前缀
     */
    public static final String BUS_MER_PREFIX = "MER_";

    /**
     * 渠道编号前缀
     */
    public static final String BUS_CHANNEL_PREFIX = "CN_";
}
