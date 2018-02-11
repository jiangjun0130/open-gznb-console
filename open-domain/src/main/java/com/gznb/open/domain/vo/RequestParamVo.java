package com.gznb.open.domain.vo;

import com.gznb.open.domain.vo.base.BaseQueryVo;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Created by jj02 on 2017/7/3.
 */
public class RequestParamVo extends BaseQueryVo implements Serializable {

    /**
     * 接口标识
     */
    @Min(value = 1, message = "平台标识无效！")
    private Integer platformId;

    @Min(value = 1, message = "模块标识无效！")
    private Integer moduleId;

    /**
     * 接口标识
     */
    @Min(value = 1, message = "接口标识无效！")
    private Integer interfaceId;

    /**
     * 参数名称
     */
    @NotBlank(message = "参数名称不能为空！")
    private String name;

    /**
     * 参数说明
     */
    @NotBlank(message = "参数说明不能为空！")
    private String nameCn;

    /**
     * 参数类型
     */
    @NotBlank(message = "参数类型不能为空！")
    private String type;

    /**
     * 是否是公共参数标识。
     * 1：是；2：否
     */
    private String commonFlag;

    /**
     * 是否必需
     */
    @NotBlank(message = "参数是否必需不能为空！")
    private String required;

    /**
     * 参数节点类型
     */
    @NotBlank(message = "参数节点类型不能为空！")
    private String treeType;

    /**
     * 父节点标识
     */
    @Min(value = 1, message = "父节点标识无效！")
    private Integer parentId;

    /**
     * 测试值
     */
    private String testValue;

    /**
     * 状态
     */
    private String status;

    /**
     * 描述
     */
    @NotBlank(message = "参数描述不能为空！")
    private String description;

    /**
     * 备注
     */
    private String note;

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Integer interfaceId) {
        this.interfaceId = interfaceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getTestValue() {
        return testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getTreeType() {
        return treeType;
    }

    public void setTreeType(String treeType) {
        this.treeType = treeType;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCommonFlag() {
        return commonFlag;
    }

    public void setCommonFlag(String commonFlag) {
        this.commonFlag = commonFlag;
    }

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }
}
