package com.gznb.open.domain.vo;

import com.gznb.open.domain.vo.base.BaseQueryVo;

import java.io.Serializable;

/**
 * 渠道查询实体
 *
 * @author jiangjun
 * @create 2017/11/15
 */
public class BusinessChannelVo extends BaseQueryVo implements Serializable {

    /**
     * 系统平台编号
     */
    private String platformNo;

    /**
     * 商户编号
     */
    private String merchantNo;

    /**
     * 商户名称
     */
    private String merchantName;

    /**
     * 渠道编号
     */
    private String channelNo;

    /**
     * 渠道名称
     */
    private String channelName;

    @Override
    public String toString() {
        return "BusinessChannelVo{" +
                "platformNo='" + platformNo + '\'' +
                ", merchantNo='" + merchantNo + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", channelNo='" + channelNo + '\'' +
                ", channelName='" + channelName + '\'' +
                '}';
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
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

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
}
