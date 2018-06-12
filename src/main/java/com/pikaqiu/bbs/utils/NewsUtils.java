package com.pikaqiu.bbs.utils;

import com.pikaqiu.bbs.dao.NewsMapper;
import com.pikaqiu.bbs.dao.NewsMapper;
import com.pikaqiu.bbs.dao.NewsMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * Create by lvls on 2018/4/9
 */
@Component
public class NewsUtils {
    @Resource
    private NewsMapper newsMapper1;

    private static NewsMapper newsMapper;

    @PostConstruct
    public void init() {
        newsMapper = newsMapper1;
    }

    public static List<String> newsAllList = null;

    public static List<String> getAllLink(){
        if(newsAllList==null){
            newsAllList = newsMapper.getAllLink();
        }
        return newsAllList;
    }

    public static void resetList(){
        newsAllList = null;
    }

}
