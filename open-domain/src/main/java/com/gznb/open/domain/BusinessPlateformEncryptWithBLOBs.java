package com.gznb.open.domain;

import java.io.Serializable;

public class BusinessPlateformEncryptWithBLOBs extends BusinessPlateformEncrypt implements Serializable {
    private String publicKeyContent;

    private String privateKeyContent;

    private static final long serialVersionUID = 1L;

    public String getPublicKeyContent() {
        return publicKeyContent;
    }

    public void setPublicKeyContent(String publicKeyContent) {
        this.publicKeyContent = publicKeyContent == null ? null : publicKeyContent.trim();
    }

    public String getPrivateKeyContent() {
        return privateKeyContent;
    }

    public void setPrivateKeyContent(String privateKeyContent) {
        this.privateKeyContent = privateKeyContent == null ? null : privateKeyContent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", publicKeyContent=").append(publicKeyContent);
        sb.append(", privateKeyContent=").append(privateKeyContent);
        sb.append("]");
        return sb.toString();
    }
}