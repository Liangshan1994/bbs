package com.pikaqiu.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lvls on 2018/1/24.
 */
@Controller
public class IndexController {

    @RequestMapping(value={"/","/index"})
    public String index() {
        return "index";
    }
}
