package com.pikaqiu.bbs.controller;

import com.pikaqiu.bbs.entity.News;
import com.pikaqiu.bbs.service.NewsService;
import com.pikaqiu.common.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lvls on 2018/2/27.
 */
@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/news-{type}-{pageNo}.html")
    public String toPageNews(@PathVariable("type") Integer type, @PathVariable("pageNo") Integer pageNo, Model model){
        PageInfo<News> newsPageInfo = newsService.selectPageByType(type,pageNo);
        model.addAttribute("pageInfo",newsPageInfo);
        return "news";
    }

    @RequestMapping("/news")
    public String toNews(Model model){
        PageInfo<News> newsPageInfo = newsService.selectPageNews();
        model.addAttribute("pageInfo",newsPageInfo);
        return "news";
    }
}
