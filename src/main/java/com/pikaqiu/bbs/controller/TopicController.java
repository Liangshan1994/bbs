package com.pikaqiu.bbs.controller;

import com.pikaqiu.bbs.entity.Board;
import com.pikaqiu.bbs.entity.Reply;
import com.pikaqiu.bbs.entity.Topic;
import com.pikaqiu.bbs.service.BoardService;
import com.pikaqiu.bbs.service.ReplyService;
import com.pikaqiu.bbs.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    private ReplyService replyService;

    @RequestMapping("/topic-{id}.html")
    public String topic(@PathVariable("id") Integer id,Model model){
        Topic topic = topicService.get(id);
        Board board = boardService.getBoardById(topic.getBoardId());
        List<Reply> replyList = replyService.selectByTopicId(topic.getId());
        model.addAttribute("topic",topic);
        model.addAttribute("board",board);
        model.addAttribute("replyList",replyList);
        return "topic";
    }

}
