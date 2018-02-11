package com.gznb.open.common.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 开放平台前端配置
 *
 * Created by jj02 on 2017/6/19.
 */
@Component
@ConfigurationProperties(prefix = "open.gznb.portal")
@ConditionalOnProperty(name = "open.gznb.module",havingValue = "portal",matchIfMissing = false)
public class PortalConfig {

    /**
     * 前端首页地址
     */
    private String indexUri;

    public String getIndexUri() {
        return indexUri;
    }

    public void setIndexUri(String indexUri) {
        this.indexUri = indexUri;
    }
}
