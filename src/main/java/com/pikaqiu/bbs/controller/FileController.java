package com.pikaqiu.bbs.controller;

import com.pikaqiu.common.utils.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lvls on 2018/2/7.
 */
@Controller
public class FileController {

    @RequestMapping(value = "/upload/image")
    public Map<String,Object> uploadImage( HttpServletRequest req) {
        Map<String,Object> rs = new HashMap<String, Object>();
        MultipartHttpServletRequest mReq = null;
        MultipartFile file = null;
        String fileName = "";
        // 原始文件名 UEDITOR创建页面元素时的alt和title属性
        String originalFileName = "";
        try {
            mReq = (MultipartHttpServletRequest)req;
            // 从config.json中取得上传文件的ID
            file = mReq.getFile("upfile");
            if(!file.isEmpty()){
                // 取得文件的原始文件名称
                fileName = file.getOriginalFilename();
                originalFileName = fileName;
                String ext = (FilenameUtils.getExtension(file.getOriginalFilename())).toLowerCase();
                String storePath = "";
                if ("jpg".equals(ext) || "png".equals(ext) || "jpeg".equals(ext) || "bmp".equals(ext)) {
                    storePath = "upload/image/";
                }else{
                    storePath = "upload/video/";
                }
                //将图片和视频保存在本地服务器
                String pathRoot = req.getSession().getServletContext().getRealPath("");
                String path = pathRoot + "/" + storePath;
                file.transferTo(new File(path+fileName));
                String doMain = FileUtils.getTopicImgPath();
                String httpImgPath = doMain + storePath + fileName;
                rs.put("state", "SUCCESS");// UEDITOR的规则:不为SUCCESS则显示state的内容
                rs.put("url",httpImgPath);  //能访问到你现在图片的路径
                rs.put("title", originalFileName);
                rs.put("original", originalFileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
            rs.put("state", "文件上传失败!"); //在此处写上错误提示信息，这样当错误的时候就会显示此信息
            rs.put("url","");
            rs.put("title", "");
            rs.put("original", "");
        }
        return rs;
    }
}
