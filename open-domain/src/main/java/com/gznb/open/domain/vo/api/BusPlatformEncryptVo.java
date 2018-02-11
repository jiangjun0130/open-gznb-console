package com.gznb.open.domain.vo.api;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 业务系统密钥对查询vo
 *
 * @author jiangjun
 * @create 2017/11/7
 */
public class BusPlatformEncryptVo extends BaseApiVo implements Serializable{

    /**
     * 系统平台编号
     */
    @NotBlank(message = "系统平台编号不能为空！")
    public String platformNo;

    /**
     * 商户编号
     */
    @NotBlank(message = "商户编号不能为空！")
    public String merchantNo;

    /**
     * 系统环境标识。1：dev环境；2：test环境；3：pre环境；4：prd环境
     */
    @NotBlank(message = "系统环境标识不能为空！")
    public String envFlag;

    @Override
    public String toString() {
        return "BusPlatformEncryptVo{" +
                "platformNo='" + platformNo + '\'' +
                ", merchantNo='" + merchantNo + '\'' +
                ", envFlag='" + envFlag + '\'' +
                '}';
    }

    public String getPlatformNo() {
        return platformNo;
    }

    public void setPlatformNo(String platformNo) {
        this.platformNo = platformNo;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }
}
