package com.pikaqiu.bbs.service;

import com.pikaqiu.bbs.entity.Board;
import com.pikaqiu.common.base.BaseService;

import java.util.List;

/**
 * Created by lvls on 2018/1/30.
 */
public interface BoardService extends BaseService<Board> {
    List<Board> getRecommendBoard();

    List<Board> getLimitBoards(Integer boardLimit);

    List<Board> getBoardsByParents(Integer parentId);

    List<Board> getParentsBoards();

}
