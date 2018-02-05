package com.pikaqiu.bbs.controller;

import com.pikaqiu.bbs.entity.Board;
import com.pikaqiu.bbs.entity.Topic;
import com.pikaqiu.bbs.service.BoardService;
import com.pikaqiu.bbs.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lvls on 2018/1/30.
 */
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private TopicService topicService;

    @RequestMapping("/board/getRecommendBoard")
    @ResponseBody
    public List<Board> getRecommendBoard(){
        List<Board> recommendBoard = boardService.getRecommendBoard();
        return recommendBoard;
    }
    @RequestMapping("/board-{id}.html")
    public String goBoard(@PathVariable("id") Integer id,Model model){
        Board board = boardService.getBoardById(id);
        //当版块类型为1时为一级版块
        if(board.getBoardType()==1){
            //获取该一级版块下的所有二级版块
            Board boardDetail = boardService.getBoardDetail(id);
            model.addAttribute("board",boardDetail);
            return "boardList";
        }else{//当版块类型为2时为二级版块
            model.addAttribute("board",board);
            List<Topic> topTopic = topicService.getTopTopic();
            List<Topic> topicByBoardId = topicService.getTopicByBoardId(id);
            model.addAttribute("topTopics",topTopic);
            model.addAttribute("topicByBoardId",topicByBoardId);
            return "board";
        }
    }

}
