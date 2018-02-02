package com.pikaqiu.bbs.entity;

import com.pikaqiu.common.base.BaseEntity;

import java.util.List;

public class Board extends BaseEntity<Board>{

    private String boardName;

    private String boardInfo;

    private Integer boardAdmin;

    private Integer boardParentId;

    private Board parentBoard;

    private Integer boardType;

    private Integer isRecommend;

    private Integer createBy;

    private List<Topic> topicList;

    private List<Board> childrenBoardList;

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName == null ? null : boardName.trim();
    }

    public Integer getBoardAdmin() {
        return boardAdmin;
    }

    public void setBoardAdmin(Integer boardAdmin) {
        this.boardAdmin = boardAdmin;
    }

    public Integer getBoardParentId() {
        return boardParentId;
    }

    public void setBoardParentId(Integer boardParentId) {
        this.boardParentId = boardParentId;
    }

    public Integer getBoardType() {
        return boardType;
    }

    public void setBoardType(Integer boardType) {
        this.boardType = boardType;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }

    public List<Board> getChildrenBoardList() {
        return childrenBoardList;
    }

    public void setChildrenBoardList(List<Board> childrenBoardList) {
        this.childrenBoardList = childrenBoardList;
    }

    public String getBoardInfo() {
        return boardInfo;
    }

    public void setBoardInfo(String boardInfo) {
        this.boardInfo = boardInfo;
    }

    public Board getParentBoard() {
        return parentBoard;
    }

    public void setParentBoard(Board parentBoard) {
        this.parentBoard = parentBoard;
    }
}