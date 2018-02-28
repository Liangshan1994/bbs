package com.pikaqiu.bbs.service.impl;

import com.pikaqiu.bbs.dao.NewsMapper;
import com.pikaqiu.bbs.entity.News;
import com.pikaqiu.bbs.service.NewsService;
import com.pikaqiu.common.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lvls on 2018/2/22.
 */
@Service(value = "newsService")
public class NewsServiceImpl extends BaseServiceImpl<NewsMapper,News> implements NewsService {
    @Autowired
    private NewsMapper newsMapper;

    public boolean isExist(String link){
        News news = newsMapper.isExist(link);
        if(news!=null){
            return true;
        }else{
            return false;
        }
    }
}
