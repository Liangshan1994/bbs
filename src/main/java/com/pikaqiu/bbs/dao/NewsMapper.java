package com.pikaqiu.bbs.dao;

import com.pikaqiu.bbs.entity.News;
import com.pikaqiu.common.base.BaseMapper;

import java.util.List;

public interface NewsMapper extends BaseMapper<News> {

    News isExist(String links);

    List<News> selectPageByType(Integer type);

    List<News> selectPageNews();
}