package com.gznb.open.domain.custom;

import com.gznb.open.domain.InterfaceRequestParams;

import java.io.Serializable;

/**
 * Created by jj02 on 2017/7/3.
 */
public class InterfaceRequestParamsCustom extends InterfaceRequestParams implements Serializable {

    /**
     * 参数类型名称
     */
    private String paramTypeName;

    /**
     * 状态名称
     */
    private String statusName;

    /**
     * 参数分段描述
     */
    private String segmentName;

    /**
     * 是否必需名称
     */
    private String requiredName;

    /**
     * 树节点类型
     */
    private String treeType;

    /**
     * 父节点名称
     */
    private String parentName;

    public String getParamTypeName() {
        return paramTypeName;
    }

    public void setParamTypeName(String paramTypeName) {
        this.paramTypeName = paramTypeName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getSegmentName() {
        return segmentName;
    }

    public void setSegmentName(String segmentName) {
        this.segmentName = segmentName;
    }

    public String getRequiredName() {
        return requiredName;
    }

    public void setRequiredName(String requiredName) {
        this.requiredName = requiredName;
    }

    public String getTreeType() {
        return treeType;
    }

    public void setTreeType(String treeType) {
        this.treeType = treeType;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
