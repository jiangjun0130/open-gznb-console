package com.gznb.open.domain.manual;

import java.util.HashMap;
import java.util.Map;

/**
 *  数据中心实体
 *
 * Created by jj02 on 2017/2/4.
 */
public class DataCenter<T> {

    /**
     * 返回处理结果标识
     *
     * 1：成功 0：失败
     */
    private  Integer flag;

    /**
     * 参数
     */
    private Map<String, String> parameters = new HashMap<String, String>();

    /**
     * 返回数据集
     */
    private Map<String,DataWrap> dataWraps = new HashMap<String,DataWrap>();

    /**
     * 返回成功信息
     */
    private String message;

    public DataCenter() {}

    public DataCenter(int flag, String message) {
        this.flag = flag;
        this.message = message;
    }


    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Map<String, DataWrap> getDataWraps() {
        return dataWraps;
    }

    public void setDataWraps(Map<String, DataWrap> dataWraps) {
        this.dataWraps = dataWraps;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
}
