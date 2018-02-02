package com.pikaqiu.bbs.service.impl;

import com.pikaqiu.bbs.dao.BoardMapper;
import com.pikaqiu.bbs.dao.TopicMapper;
import com.pikaqiu.bbs.entity.Board;
import com.pikaqiu.bbs.entity.Topic;
import com.pikaqiu.bbs.service.BoardService;
import com.pikaqiu.common.base.BaseServiceImpl;
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

    /**
     * 获取推荐版块
     */
    @Override
    public List<Board> getRecommendBoard() {
        return boardMapper.getRecommendBoard();
    }

    @Override
    public List<Board> getLimitBoards(Integer boardLimit) {
        List<Board> boardList;
        boardList = boardMapper.getBoardsByLimit(boardLimit);
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

    @Override
    public List<Board> getParentsBoards(Integer parentBoardLimit) {
        List<Board> parentsBoards = boardMapper.getParentsBoards(parentBoardLimit);
        for (Board parentsBoard : parentsBoards) {
            List<Board> boardsByParents = boardMapper.getBoardsByParents(parentsBoard.getId());
            if(boardsByParents.size()>5){
                parentsBoard.setChildrenBoardList(boardsByParents.subList(0,5));
            }else{
                parentsBoard.setChildrenBoardList(boardsByParents);
            }
        }
        return parentsBoards;
    }

    @Override
    public Board getBoardById(Integer id) {
        Board board = boardMapper.get(id);
        Board parentBoard = boardMapper.get(board.getBoardParentId());
        if(parentBoard!=null){
            board.setParentBoard(parentBoard);
        }
        return board;
    }
}
