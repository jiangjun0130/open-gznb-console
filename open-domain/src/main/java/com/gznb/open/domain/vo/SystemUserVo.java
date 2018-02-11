package com.gznb.open.domain.vo;

import com.gznb.open.domain.vo.base.BaseQueryVo;
import com.gznb.open.domain.vo.base.PageBean;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kl09 on 2017/6/29.
 */
public class SystemUserVo implements Serializable {
    private Integer id;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空！")
    private String name;

    /**
     * 手机号码
     */
    @NotBlank(message = "手机号码不能为空！")
    private String mobile;

    /**
     * 用户类型
     */
    @NotBlank(message = "用户类型不能为空！")
    private String type;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 注册时间
     */
    private Date registerTime;

    /**
     * 创建人
     */
    private Date createUser;

    /**
     * 备注
     */
    private String note;

    private Integer audioStatus;

    private PageBean pageBean = new PageBean(); // 分页信息


    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Date createUser) {
        this.createUser = createUser;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getAudioStatus() {
        return audioStatus;
    }

    public void setAudioStatus(Integer audioStatus) {
        this.audioStatus = audioStatus;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    @Override
    public String toString() {
        return "SystemUserVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", type='" + type + '\'' +
                ", updateTime=" + updateTime +
                ", registerTime=" + registerTime +
                ", createUser=" + createUser +
                ", note='" + note + '\'' +
                ", audioStatus=" + audioStatus +
                '}';
    }
}
