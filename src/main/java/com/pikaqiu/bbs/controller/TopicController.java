package com.pikaqiu.bbs.controller;

import com.pikaqiu.bbs.entity.*;
import com.pikaqiu.bbs.service.BoardService;
import com.pikaqiu.bbs.service.ReplyService;
import com.pikaqiu.bbs.service.TopicService;
import com.pikaqiu.bbs.service.UserInfoService;
import com.pikaqiu.bbs.utils.UserUtils;
import com.pikaqiu.common.interceptor.LoginAuth;
import com.pikaqiu.common.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lvls on 2018/2/1.
 */
@Controller
public class TopicController {

    @Autowired
    private TopicService topicService;
    @Autowired
    private BoardService boardService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private ReplyService replyService;

    @RequestMapping("/topic-{id}-{pageNo}.html")
    public String topic(@PathVariable("id") Integer id,@PathVariable("pageNo") Integer pageNo,Model model){
        Topic topic = topicService.get(id);
        UserInfo userInfo = userInfoService.get(topic.getUserId());
        topic.setUserInfo(userInfo);
        topic.setView(topic.getView() + 1);
        topicService.update(topic);
        PageInfo<Reply> pageInfo = replyService.selectPageByTopicId(topic.getId(), pageNo);
        List<Reply> replyList = pageInfo.getList();
        model.addAttribute("replyNum",replyList.size());
        model.addAttribute("topic",topic);
        model.addAttribute("board",topic.getBoard());
        model.addAttribute("replyList",replyList);
        model.addAttribute("pageInfo",pageInfo);
        return "topic";
    }

    @LoginAuth
    @RequestMapping("/newTopic-{boardId}.html")
    public String NewTopic(@PathVariable("boardId") Integer boardId,Model model){
        Board board = boardService.get(boardId);
        model.addAttribute("board",board);
        return "newTopic";
    }

    @LoginAuth
    @RequestMapping("/saveNewTopic")
    public String saveNewTopic(Topic topic, HttpServletRequest request, Model model){
        UserInfo user = UserUtils.getUser(request);
        topic.setCreateBy(user.getUserId());
        topic.setUpdateBy(user.getUserId());
        topic.setUserId(user.getUserId());
        topic.setIsElite(0);
        topic.setIsTop(0);
        topic.setView(0);
        topicService.insert(topic);
        return "redirect:/topic-"+topic.getId()+"-1.html";
    }

    @ResponseBody
    @RequestMapping("getNewTopic")
    public List<Topic> getNewTopic(){
        return topicService.getNewTopic();
    }

    @ResponseBody
    @RequestMapping("getEliteTopic")
    public List<Topic> getEliteTopic(){
        return topicService.getEliteTopic();
    }

}
