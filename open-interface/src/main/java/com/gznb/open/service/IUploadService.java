package com.gznb.open.service;

/**
 * 上传文件接口
 *
 * Created by jj02 on 2017/6/26.
 */
public interface IUploadService {

    /**
     * 上传文件
     * @param pic
     * @param fileName
     * @param fileSize
     * @return
     * @throws Exception
     */
    String uploadPic(byte[] pic,String fileName,Long fileSize) throws Exception;

}
