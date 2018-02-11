package com.gznb.open.domain.vo;

import com.gznb.open.domain.vo.base.BaseQueryVo;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * 接口请求参数示例vo
 *
 * Created by jj02 on 2017/7/6.
 */
public class ReqParamSampleVo extends BaseQueryVo implements Serializable {

    /**
     * 请求示例标识
     */
    private Integer sampleId;

    /**
     * 接口标识
     */
    @Min(value = 1, message = "接口标识无效！")
    private Integer interfaceId;

    /**
     * 请求示例内容
     */
    private String sampleContent;

    /**
     * 请求示例地址
     */
    private String sampleUrl;

    public Integer getSampleId() {
        return sampleId;
    }

    public void setSampleId(Integer sampleId) {
        this.sampleId = sampleId;
    }

    public Integer getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Integer interfaceId) {
        this.interfaceId = interfaceId;
    }

    public String getSampleContent() {
        return sampleContent;
    }

    public void setSampleContent(String sampleContent) {
        this.sampleContent = sampleContent;
    }

    public String getSampleUrl() {
        return sampleUrl;
    }

    public void setSampleUrl(String sampleUrl) {
        this.sampleUrl = sampleUrl;
    }
}
