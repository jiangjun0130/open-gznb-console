package com.gznb.open.domain.manual;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统各个环境枚举
 *
 * @author jiangjun
 * @create 2017/10/25
 */
public enum EnvironmentEnum {

    ENVIRONMENT_DEV("1","dev环境"),
    ENVIRONMENT_TEST("2","test环境"),
    ENVIRONMENT_PRE("3","pre环境"),
    ENVIRONMENT_PRD("4","prd环境");

    /**
     * 环境代码
     */
    private String envCode;

    /**
     * 环境名称
     */
    private String envName;

    public static Map<String,EnvironmentEnum> environmentEnumMap;

    static {
        environmentEnumMap = new HashMap<>(4);
        for(EnvironmentEnum env : EnvironmentEnum.values()){
            environmentEnumMap.put(env.getEnvCode(),env);
        }
    }

    public static EnvironmentEnum getEnvironment(String envCode){
        if(StringUtils.isBlank(envCode)){
            return null;
        }
        return environmentEnumMap.get(envCode);
    }


    EnvironmentEnum(String envCode, String envName) {
        this.envCode = envCode;
        this.envName = envName;
    }

    public String getEnvCode() {
        return envCode;
    }

    public void setEnvCode(String envCode) {
        this.envCode = envCode;
    }

    public String getEnvName() {
        return envName;
    }

    public void setEnvName(String envName) {
        this.envName = envName;
    }
}
