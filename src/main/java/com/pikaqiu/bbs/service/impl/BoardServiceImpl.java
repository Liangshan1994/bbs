package com.pikaqiu.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.pikaqiu.bbs.dao.BoardMapper;
import com.pikaqiu.bbs.dao.TopicMapper;
import com.pikaqiu.bbs.dao.UserInfoMapper;
import com.pikaqiu.bbs.entity.Board;
import com.pikaqiu.bbs.entity.Topic;
import com.pikaqiu.bbs.service.BoardService;
import com.pikaqiu.common.base.BaseServiceImpl;
import com.pikaqiu.common.config.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lvls on 2018/1/30.
 */
@Service(value = "boardService")
public class BoardServiceImpl extends BaseServiceImpl<BoardMapper,Board> implements BoardService {

    @Autowired
    private BoardMapper boardMapper;
    @Autowired
    private TopicMapper topicMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 获取推荐版块
     */
    @Override
    public List<Board> getRecommendBoard() {
        return boardMapper.getRecommendBoard();
    }

    @Override
    public List<Board> getLimitBoards(Integer pageNo) {
        List<Board> boardList;
        PageHelper.startPage(pageNo, Global.BOARD_SIZE);
        boardList = boardMapper.getBoardsByLimit();
        for (Board board : boardList) {
            List<Topic> topicList = topicMapper.selectByBoardId(board.getId());
            board.setTopicList(topicList);
        }
        return boardList;
    }

    @Override
    public List<Board> getBoardsByParents(Integer parentId) {
        return boardMapper.getBoardsByParents(parentId);
    }

    /**
     * 一堆烂代码，记得优化
     */
    @Override
    public List<Board> getParentsBoards() {
        //获取所有一级版块
        PageHelper.startPage(1,Global.BOARD_SIZE);
        List<Board> parentsBoards = boardMapper.getParentsBoards();
        for (Board parentsBoard : parentsBoards) {
//            getChildrenDetilList(parentsBoard);
            List<Board> childrenBoardList = parentsBoard.getChildrenBoardList();
            for (Board board : childrenBoardList) {
                //如果不是一级版块获取该板块最新一条主题
                if(board.getBoardType()!=1){
                    getLastTopic(board);
                }
            }
        }
        return parentsBoards;
    }

    @Override
    public Board get(Integer boardId){
        Board board = boardMapper.get(boardId);
        Board parentBoard = boardMapper.get(board.getBoardParentId());
        board.setParentBoard(parentBoard);
        getLastTopic(board);
        return board;
    }

    private void getLastTopic(Board board) {
        List<Topic> newTopic = topicMapper.selectByBoardId(board.getId());
        if(newTopic.size()>0){
            int viewTotal = 0;
            for (Topic topic : newTopic) {
                viewTotal += topic.getView();
            }
            board.setViewTotal(viewTotal);
            Topic topic = newTopic.get(0);
            board.setLastTopic(topic);
            board.setTopicList(newTopic);
        }
    }
}
