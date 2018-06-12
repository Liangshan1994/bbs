package com.pikaqiu.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.util.Date;
import java.util.Random;

/**
 * Created by lvls on 2018/2/7.
 * 文件操作工具类
 * 实现文件的创建、删除、复制、压缩、解压以及目录的创建、删除、复制、压缩解压等功能
 */
public class FileUtils extends org.apache.commons.io.FileUtils {

    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    @Value("pikaqiu.images.topicImgPath")
    private static String topicImgPath;

    public static String saveSimpleNewImage(String suffix,String oldFileName,InputStream inFile){
        if(oldFileName == null || "".equals(oldFileName) ){
            return null;
        }
        String newPath = null;
        String fileSuffix = FileUtils.getFileSuffix(oldFileName);
        //要生成的新文件
        newPath = topicImgPath+FileUtils.getNewFileName(suffix)+fileSuffix;
        File newFile = new File(newPath);
        try(BufferedInputStream bis = new BufferedInputStream(inFile);
            FileOutputStream fos = new FileOutputStream(newFile)
        ){
            //检查存放的文件夹,没有则新建
            File directory = new File(topicImgPath);
            if(!directory.exists()){
                directory.mkdirs();
            }
            byte[] b = new byte[1024*1024];
            int length = -1;
            while((length = bis.read(b, 0, b.length))!=-1){
                fos.write(b, 0, length);
            }
        }catch(Exception ex){
            newPath = null;
        }finally{
            if(inFile != null){
                try {
                    inFile.close();
                } catch (IOException e) {
                }
            }
        }
        return newPath;
    }

    public static String getNewFileName(String suffix){
        Date d = new Date();
        Random r = new Random();
        return Long.toString(d.getTime())+r.nextInt(10000)+"_"+suffix;
    }

    public static String getFileSuffix(String fileName){
        String fileSuffix = null;
        // 获取后缀
        if(fileName != null && !"".equals(fileName)){
            fileSuffix = fileName.substring(fileName.lastIndexOf('.'), fileName.length());
        }
        return fileSuffix;
    }

    public static String getTopicImgPath() {
        return topicImgPath;
    }
}
