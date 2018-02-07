package com.pikaqiu.bbs.service.impl;

import com.pikaqiu.bbs.dao.BoardMapper;
import com.pikaqiu.bbs.dao.TopicMapper;
import com.pikaqiu.bbs.dao.UserInfoMapper;
import com.pikaqiu.bbs.entity.Board;
import com.pikaqiu.bbs.entity.Topic;
import com.pikaqiu.bbs.entity.UserInfo;
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

    /**
     * 一堆烂代码，记得优化
     */
    @Override
    public List<Board> getParentsBoards(Integer parentBoardLimit) {
        //获取所有一级版块
        List<Board> parentsBoards = boardMapper.getParentsBoards(parentBoardLimit);
        for (Board parentsBoard : parentsBoards) {
            getChildrenDetilList(parentsBoard);
        }
        return parentsBoards;
    }

    /**
     * 查询出一个版块下的所有子版块和对应的管理员以及最新帖子
     */
    private void getChildrenDetilList(Board board) {
        //遍历获取一级版块下的子版块
        //设置版块管理员信息
        UserInfo userInfo = userInfoMapper.get(board.getBoardAdmin());
        board.setAdminUserInfo(userInfo);
        List<Board> boardsByParents = boardMapper.getBoardsByParents(board.getId());
        if(boardsByParents.size()>5){
            board.setChildrenBoardList(boardsByParents.subList(0,5));
        }else{
            board.setChildrenBoardList(boardsByParents);
        }
        List<Board> childrenBoardList = board.getChildrenBoardList();
        //遍历二级板块，设置版块管理员信息和最新主题
        for (Board children : childrenBoardList) {
            UserInfo childrenBoardAdminUserInfo = userInfoMapper.get(children.getBoardAdmin());
            children.setAdminUserInfo(childrenBoardAdminUserInfo);
            //获取该板块最新一条主题
            List<Topic> newTopic = topicMapper.selectByBoardId(children.getId());
            Topic topic = newTopic.get(0);
            UserInfo topicUserInfo = userInfoMapper.get(topic.getUserId());
            topic.setUserInfo(topicUserInfo);
            children.setLastTopic(topic);
            children.setTopicList(newTopic);
        }
    }

    /**
     * 获取父级版块
     */
    @Override
    public Board getBoardById(Integer id) {
        Board board = boardMapper.get(id);
        Board parentBoard = boardMapper.get(board.getBoardParentId());
        if(parentBoard!=null){
            board.setParentBoard(parentBoard);
        }
        return board;
    }

    @Override
    public Board getBoardDetail(Integer id) {
        Board board = getBoardById(id);
        getChildrenDetilList(board);
        return board;
    }
}
