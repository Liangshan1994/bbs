package com.pikaqiu.bbs.controller;

import com.pikaqiu.bbs.entity.Reply;
import com.pikaqiu.bbs.entity.UserInfo;
import com.pikaqiu.bbs.service.ReplyService;
import com.pikaqiu.bbs.service.TopicService;
import com.pikaqiu.bbs.utils.UserUtils;
import com.pikaqiu.common.interceptor.LoginAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by lvls on 2018/2/7.
 */
@Controller
public class ReplyController {

    @Autowired
    private ReplyService replyService;
    @Autowired
    private TopicService topicService;

    @LoginAuth
    @RequestMapping("/saveReply")
    public String saveReply(Reply reply, HttpServletRequest request){
        UserInfo user = UserUtils.getUser(request);
        Integer topicId = reply.getTopicId();
        Integer replynum = replyService.getReplyNumByTopicId(topicId);
        reply.setUserId(user.getUserId());
        reply.setReplyTime(new Date());
        reply.setUpdateBy(user.getUserId());
        reply.setReplySort(replynum+1);
        replyService.insert(reply);
        return "redirect:/topic-"+reply.getTopicId()+"-1.html";
    }
}
