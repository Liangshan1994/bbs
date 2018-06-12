package com.pikaqiu.bbs.controller;

import com.pikaqiu.bbs.entity.Topic;
import com.pikaqiu.bbs.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Create by lvls on 2018/4/13
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(value = {"","/"})
    public String admin(){
        return "admin/index";
    }

    @RequestMapping("test")
    @ResponseBody
    public List<Topic> getTopicTest(){
        return topicService.findListTestRedis();
    }

}
