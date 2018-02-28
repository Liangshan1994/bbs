package com.pikaqiu.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lvls on 2018/2/27.
 */
@Controller
public class NewsController {

    @RequestMapping("/news")
    public String toNews(){

        return "news";
    }
}
