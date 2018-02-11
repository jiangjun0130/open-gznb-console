package com.gznb.open.domain.vo.api;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * api接口父类
 *
 * @author jiangjun
 * @create 2017/11/8
 */
public class BaseApiVo implements Serializable{

    /**
     * 数据签名
     */
    @NotBlank(message = "数据签名不能为空！")
    public String sign;

    @Override
    public String toString() {
        return "BaseApiVo{" +
                "sign='" + sign + '\'' +
                '}';
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
