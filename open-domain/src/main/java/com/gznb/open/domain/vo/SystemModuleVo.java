package com.gznb.open.domain.vo;

import com.gznb.open.domain.vo.base.BaseQueryVo;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Created by jj02 on 2017/6/28.
 */
public class SystemModuleVo extends BaseQueryVo implements Serializable {

    /**
     * 系统平台id
     */
    @Min(value = 1, message = "系统平台标识无效！")
    private Integer platformId;

    /**
     * 模块标识
     */
    private Integer moduleId;

    /**
     * 模块名称
     */
    @NotBlank(message = "系统模块名称不能为空！")
    private String name;

    /**
     * 模块路径
     */
/*    @NotBlank(message = "系统模块路径不能为空！")*/
    private String path;

    /**
     * 状态
     */
    private String status;

    /**
     * 系统模块描述
     */
    @NotBlank(message = "系统模块描述不能为空！")
    private String description;

    private String note;

    public String getCatalogType() {
        return catalogType;
    }

    public void setCatalogType(String catalogType) {
        this.catalogType = catalogType;
    }

    /**
     * 平台项目字典类型
     * @return
     */
    private String catalogType;
    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
