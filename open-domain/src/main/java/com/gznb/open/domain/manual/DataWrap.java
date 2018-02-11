package com.gznb.open.domain.manual;

import java.io.Serializable;
import java.util.List;

/**
 * Created by JJ on 2016/7/13.
 */
public class DataWrap<T> implements Serializable{

    protected T data;

    /**
     * 数据列表
     */
    protected List<T> dataList;

    /**
     * 数据实体
     */
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
