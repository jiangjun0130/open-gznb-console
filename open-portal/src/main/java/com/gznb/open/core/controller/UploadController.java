package com.gznb.open.core.controller;

import com.gznb.open.common.config.SystemConfig;
import com.gznb.open.core.controller.base.AbstractController;
import com.gznb.open.service.IUploadService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件上传
 * <p>
 * Created by jj02 on 2017/6/26.
 */
@Controller
@RequestMapping("/upload")
public class UploadController extends AbstractController<UploadController> {

    @Autowired
    private SystemConfig systemConfig;

    @Autowired
    private IUploadService uploadService;

    /**
     * 上传单张图片
     * @param pic
     * @param response
     * @throws Exception
     */
    @PostMapping(value = "/uploadPic")
    public void uploadPic(@RequestParam(required = false) MultipartFile pic, HttpServletResponse response) throws Exception {
        if(pic == null || pic.isEmpty()){
            return;
        }
        String picPath = uploadService.uploadPic(pic.getBytes(), pic.getOriginalFilename(), pic.getSize());
        String url = systemConfig.getImageUrl() + picPath;
        //json
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("url", url);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(jsonObject.toString());
    }

    /**
     * 上传多张图片
     *
     * @param pics
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/uploadPics.do")
    @ResponseBody
    public List<String> uploadPics(@RequestParam(required = false) MultipartFile[] pics,
                                   HttpServletResponse response) throws Exception {
        List<String> list = new ArrayList<>();
        for (MultipartFile pic : pics) {
            System.out.println(pic.getOriginalFilename());
            String picPath = uploadService.uploadPic(pic.getBytes(), pic.getOriginalFilename(), pic.getSize());
            String url = systemConfig.getImageUrl() + picPath;

            list.add(url);
        }
        return list;
    }

}
