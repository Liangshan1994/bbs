package com.pikaqiu.bbs.service;

import com.pikaqiu.bbs.entity.News;
import com.pikaqiu.common.base.BaseService;
import com.pikaqiu.common.pagehelper.PageInfo;

/**
 * Created by lvls on 2018/2/22.
 */
public interface NewsService extends BaseService<News> {

    boolean isExist(String link);

    PageInfo<News> selectPageByType(Integer type, Integer pageNo);

    PageInfo<News> selectPageNews();

    News getNewsDetail(Integer id);
}
