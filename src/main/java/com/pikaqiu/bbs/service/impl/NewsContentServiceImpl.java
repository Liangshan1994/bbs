package com.pikaqiu.bbs.service.impl;

import com.pikaqiu.bbs.dao.NewsContentMapper;
import com.pikaqiu.bbs.dao.NewsMapper;
import com.pikaqiu.bbs.entity.News;
import com.pikaqiu.bbs.entity.NewsContent;
import com.pikaqiu.bbs.service.NewsContentService;
import com.pikaqiu.bbs.service.NewsService;
import com.pikaqiu.common.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lvls on 2018/2/22.
 */
@Service(value = "newsContentService")
public class NewsContentServiceImpl extends BaseServiceImpl<NewsContentMapper,NewsContent> implements NewsContentService {
    @Autowired
    private NewsContentMapper newsContentMapper;

}
