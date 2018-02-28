package com.pikaqiu.bbs.controller;

import com.pikaqiu.bbs.utils.TopicUtils;
import com.pikaqiu.common.pagehelper.PageInfo;
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
    @RequestMapping("/board-{id}-{pageNo}.html")
    public String goBoard(@PathVariable("id") Integer id, @PathVariable("pageNo") Integer pageNo, Model model){
        Board board = boardService.getBoardDetail(id);
        model.addAttribute("board",board);
        //当版块类型为1时为一级版块
        if(board.getBoardType()==1){
            return "boardList";
        }else{//当版块类型为2时为二级版块
            //获取当前版块的置顶主题
            List<Topic> topTopic = topicService.getTopTopicByBoard(id);
            //分页获取当前版块的主题
            PageInfo<Topic> pageInfo = topicService.getPageTopicByBoardId(id,pageNo);
            //获取当前板块所有主题
            List<Topic> topicByBoardId = topicService.getTopicByBoardId(id);
            Integer toDayTopicNum = TopicUtils.getToDayTopicNum(topicByBoardId);
            model.addAttribute("toDayTopicNum",toDayTopicNum);
            model.addAttribute("topTopics",topTopic);
            model.addAttribute("pageInfo",pageInfo);
            model.addAttribute("topicByBoardId",pageInfo.getList());
            return "board";
        }
    }

}
