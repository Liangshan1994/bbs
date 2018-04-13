package com.pikaqiu.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create by lvls on 2018/4/13
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value = {"","/"})
    public String admin(){
        return "admin/index";
    }

}
