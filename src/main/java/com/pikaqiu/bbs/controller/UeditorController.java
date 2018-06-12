package com.pikaqiu.bbs.controller;

import com.pikaqiu.common.ueditor.PublicMsg;
import com.pikaqiu.common.ueditor.Ueditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 * Created by lvls on 2018/2/28.
 */
@Controller
public class UeditorController {

    private final Logger logger = LoggerFactory.getLogger(UeditorController.class);
    @Value("${pikaqiu.images.uploadPath}")
    private String imageSavePath;

    @RequestMapping(value="/ueditor")
    @ResponseBody
    public String ueditor(HttpServletRequest request) {
        return PublicMsg.UEDITOR_CONFIG;
    }

    @RequestMapping(value="/imgUpload")
    @ResponseBody
    public Ueditor imgUpload(MultipartFile upfile) {
        Ueditor ueditor = new Ueditor();
        // 获取文件名
        String fileName = upfile.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String filePath = imageSavePath;
//        String filePath = "f://"+imageSavePath;
        // 解决中文问题，liunx下中文路径，图片显示问题
        Date d = new Date();
        Random r = new Random();
        String saveName = String.valueOf(d.getTime()+r.nextInt(10000)) + suffixName;
        File dest = new File(filePath);
        // 检测是否存在目录
        if (!dest.exists()) {
            dest.mkdirs();
        }
        File uploadFile = new File(dest + "/" + saveName);
        try {
            upfile.transferTo(uploadFile);
            ueditor.setState("SUCCESS");
            ueditor.setOriginal(saveName);
            ueditor.setUrl("/getImg?filePath="+imageSavePath + saveName);
            return ueditor;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ueditor.setState("ERROR");
        return ueditor;
    }

    private void getFile(String filePath, HttpServletResponse response) {
        File file = new File(filePath);
//        File file = new File("F://"+filePath);
        if(!file.exists()){
            return;
        }
        try(BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
            FileInputStream fis = new FileInputStream(file)){
            byte[] b = new byte[1024*1024];
            int length;
            while((length = fis.read(b, 0, b.length)) != -1){
                bos.write(b, 0, length);
            }
        } catch (Exception ex) {
            logger.info("getFile",ex);
        }
    }

    @RequestMapping(value = "getImg")
    public void getImg(String filePath, HttpServletResponse response) {
        if(filePath.indexOf(imageSavePath) != 0){
            return;
        }
        this.getFile(filePath, response);
    }
}
