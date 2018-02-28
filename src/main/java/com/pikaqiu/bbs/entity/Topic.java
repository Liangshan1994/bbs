package com.pikaqiu.bbs.entity;

import com.pikaqiu.common.base.BaseEntity;

import java.util.Date;

public class Topic extends BaseEntity<Topic> {

    private String title;   //主题标题

    private Integer userId;     //用户id

    private Integer boardId;    //所属板块

    private Integer type;   //类型

    private Integer isTop;  //是否置顶

    private Integer isElite;    //是否精华

    private String content; //主题内容

    private Integer lastReplyUserId;    //最后回复用户

    private Date lastReplyDate; //最后回复时间

    private UserInfo userInfo;

    private Board board;

    private Integer view;//访问量

    private Integer replyNum;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getIsElite() {
        return isElite;
    }

    public void setIsElite(Integer isElite) {
        this.isElite = isElite;
    }

    public Integer getLastReplyUserId() {
        return lastReplyUserId;
    }

    public void setLastReplyUserId(Integer lastReplyUserId) {
        this.lastReplyUserId = lastReplyUserId;
    }

    public Date getLastReplyDate() {
        return lastReplyDate;
    }

    public void setLastReplyDate(Date lastReplyDate) {
        this.lastReplyDate = lastReplyDate;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public Integer getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(Integer replyNum) {
        this.replyNum = replyNum;
    }
}