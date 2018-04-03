package com.pikaqiu.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.pikaqiu.bbs.dao.NewsContentMapper;
import com.pikaqiu.bbs.dao.NewsMapper;
import com.pikaqiu.bbs.entity.News;
import com.pikaqiu.bbs.entity.NewsContent;
import com.pikaqiu.bbs.service.NewsService;
import com.pikaqiu.common.base.BaseServiceImpl;
import com.pikaqiu.common.config.Global;
import com.pikaqiu.common.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lvls on 2018/2/22.
 */
@Service(value = "newsService")
public class NewsServiceImpl extends BaseServiceImpl<NewsMapper,News> implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private NewsContentMapper newsContentMapper;

    public boolean isExist(String link){
        News news = newsMapper.isExist(link);
        return news!=null;
    }

    @Override
    public PageInfo<News> selectPageByType(Integer type, Integer pageNo) {
        PageHelper.startPage(pageNo, Global.NEWS_SIZE);
        List<News> newsList;
        if(type==0){
            newsList = newsMapper.selectPageNews();
        }else{
            newsList = newsMapper.selectPageByType(type);
        }
        PageInfo<News> pageInfo = new PageInfo<>(newsList);
        return pageInfo;
    }

    @Override
    public PageInfo<News> selectPageNews() {
        PageHelper.startPage(1, Global.NEWS_SIZE);
        List<News> newsList = newsMapper.selectPageNews();
        PageInfo<News> pageInfo = new PageInfo<>(newsList);
        return pageInfo;
    }

    @Override
    public News getNewsDetail(Integer id) {
        News news = newsMapper.get(id);
        NewsContent newsContent = newsContentMapper.get(news.getContentId());
        news.setContent(newsContent.getContent());
        return news;
    }

}
