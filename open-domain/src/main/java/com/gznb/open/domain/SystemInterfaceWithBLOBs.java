package com.gznb.open.domain;

import java.io.Serializable;

public class SystemInterfaceWithBLOBs extends SystemInterface implements Serializable {
    private String reqSignRule;

    private String respSignRule;

    private static final long serialVersionUID = 1L;

    public String getReqSignRule() {
        return reqSignRule;
    }

    public void setReqSignRule(String reqSignRule) {
        this.reqSignRule = reqSignRule == null ? null : reqSignRule.trim();
    }

    public String getRespSignRule() {
        return respSignRule;
    }

    public void setRespSignRule(String respSignRule) {
        this.respSignRule = respSignRule == null ? null : respSignRule.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", reqSignRule=").append(reqSignRule);
        sb.append(", respSignRule=").append(respSignRule);
        sb.append("]");
        return sb.toString();
    }
}