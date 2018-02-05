package com.pikaqiu.bbs.controller;

import com.pikaqiu.bbs.entity.Board;
import com.pikaqiu.bbs.service.BoardService;
import com.pikaqiu.bbs.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private BoardService boardService;
    @Autowired
    private UserInfoService userInfoService;

    @Value("${pikaqiu.board.limit}")
    private Integer boardLimit;

    @Value("${pikaqiu.board.parentLimit}")
    private Integer parentBoardLimit;

    @RequestMapping(value={"/","/index"})
    public String index(Model model) {
        List<Board> parentsBoards = boardService.getParentsBoards(parentBoardLimit);
        model.addAttribute("parentsBoards",parentsBoards);
        return "index";
    }

    @RequestMapping(value="/getAllNav")
    @ResponseBody
    public List<Map<String,Object>> getAllNav() {
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("title","首页");
        map.put("url","/index");
        list.add(map);
        return list;
    }
}
