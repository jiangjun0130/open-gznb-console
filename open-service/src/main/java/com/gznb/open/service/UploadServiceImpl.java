package com.gznb.open.service;

import com.gznb.fastdfs.client.FastDFSClient;
import com.gznb.open.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 上传文件接口实现类
 *
 * Created by jj02 on 2017/6/26.
 */
@Service("uploadService")
public class UploadServiceImpl extends AbstractService<UploadServiceImpl> implements IUploadService {
    @Autowired
    private FastDFSClient fastDFSClient;

    @Override
    public String uploadPic(byte[] pic, String fileName, Long fileSize) throws Exception {
       /* return FastDFSUtils.uploadPic(pic,fileName,fileSize);*/
        String uploadPath = fastDFSClient.uploadFile(pic, fileName, fileSize);
        logger.info("uploadPath:{}", uploadPath);
        return uploadPath;
    }
}
