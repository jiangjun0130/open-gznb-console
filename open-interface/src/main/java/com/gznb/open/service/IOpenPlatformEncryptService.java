package com.gznb.open.service;

import com.gznb.open.domain.OpenPlatformEncrypt;

import java.util.List;
import java.util.Map;

public interface IOpenPlatformEncryptService {

    /**
     * 生成开放平台秘钥信息<br/>
     * step1、将之前所有记录状态置为删除<br/>
     * step2、再次生成各个环境秘钥<br/>
     * step3、将生成的秘钥文件上传的文件服务器
     * step4、保存秘钥文件到文件表
     * step5、讲生成的秘钥信息保存到数据库<br/>
     *
     * @throws Exception
     */
    void generateKey() throws Exception;

    /**
     * 查询最新秘钥信息
     * 根据环境分组（key）
     *
     * @return
     */
    Map<String, List<OpenPlatformEncrypt>> query();
}
