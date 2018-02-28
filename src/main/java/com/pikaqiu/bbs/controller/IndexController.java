package com.pikaqiu.bbs.controller;

import com.pikaqiu.bbs.entity.Board;
import com.pikaqiu.bbs.entity.Topic;
import com.pikaqiu.bbs.entity.UserInfo;
import com.pikaqiu.bbs.service.BoardService;
import com.pikaqiu.bbs.service.TopicService;
import com.pikaqiu.bbs.service.UserInfoService;
import com.pikaqiu.bbs.utils.TopicUtils;
import com.pikaqiu.common.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lvls on 2018/1/24.
 */
@Controller
public class IndexController {

    @Autowired
    private TopicService topicService;
    @Autowired
    private BoardService boardService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private MailService mailService;

    @RequestMapping(value={"/","/index"})
    public String index(Model model) {
        List<Board> parentsBoards = boardService.getParentsBoards();
        model.addAttribute("parentsBoards",parentsBoards);
        return "index";
    }

    @RequestMapping(value="/getAllNav")
    @ResponseBody
    public List<Map<String,Object>> getAllNav() {
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> index = new HashMap<>();
        index.put("title","首页");
        index.put("url","/index");
        list.add(index);
        Map<String,Object> news = new HashMap<>();
        news.put("title","新闻");
        news.put("url","/news");
        list.add(news);
        return list;
    }

    @RequestMapping(value="/getTopicAndUserNum")
    @ResponseBody
    public Map<String,Object> getTopicAndUserNum() {
        Map<String,Object> map = new HashMap<>();
        List<UserInfo> allUserInfo = userInfoService.getAllUser();
        List<Topic> list = topicService.findList(new Topic());
        int toDayNum = TopicUtils.getToDayTopicNum(list);
        int lastDayNum = TopicUtils.getLastDayTopicNum(list);
        map.put("newUser",allUserInfo.get(0));
        map.put("userNum",allUserInfo.size());
        map.put("topicNum",list.size());
        map.put("toDayNum",toDayNum);
        map.put("lastDayNum",lastDayNum);
        return map;
    }
}
