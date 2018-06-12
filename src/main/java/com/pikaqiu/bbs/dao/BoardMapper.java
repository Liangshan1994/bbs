package com.pikaqiu.bbs.dao;

import com.pikaqiu.bbs.entity.Board;
import com.pikaqiu.common.base.BaseMapper;

import java.util.List;

public interface BoardMapper extends BaseMapper<Board> {

    List<Board> getRecommendBoard();

    List<Board> getBoardsByLimit();

    List<Board> getBoardsByParents(Integer parentId);

    List<Board> getParentsBoards();

}