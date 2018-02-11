package com.gznb.open.domain.vo.base;

import java.io.Serializable;
import java.util.List;

/**
 * 查询实体基类
 *
 * Created by jj02 on 2016/10/11.
 */
public class BaseQueryVo implements Serializable{

    private String id;

    private String optType; // 标识修改还是新增操作

    private PageBean pageBean = new PageBean(); // 分页信息

    // 批量操作信息

    private List<String> listId; // 批量操作id

    private String btnStatus; // 批量更新状态码

    public String getBtnStatus() {
        return btnStatus;
    }

    public void setBtnStatus(String btnStatus) {
        this.btnStatus = btnStatus;
    }

    public List<String> getListId() {
        return listId;
    }

    public void setListId(List<String> listId) {
        this.listId = listId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOptType() {
        return optType;
    }

    public void setOptType(String optType) {
        this.optType = optType;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }
}
