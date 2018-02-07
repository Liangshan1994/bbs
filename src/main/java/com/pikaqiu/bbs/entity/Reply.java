package com.pikaqiu.bbs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pikaqiu.common.base.BaseEntity;

import java.util.Date;

public class Reply extends BaseEntity<Reply>{

    private Integer topicId;//主题id

    private Integer userId; //回复人id

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date replyTime; //回复时间

    private Integer replySort;  //回复顺序

    private Integer boardId;    //所属板块

    private String content; //回复内容

    private String userName;    //回复人名字

    private String userImg; //回复人头像

    private String userSign;//回复人个签

    private Integer userTopicNum;//用户主题数

    private Integer userReplyNum;//用户帖子数

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public Integer getReplySort() {
        return replySort;
    }

    public void setReplySort(Integer replySort) {
        this.replySort = replySort;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserSign() {
        return userSign;
    }

    public void setUserSign(String userSign) {
        this.userSign = userSign;
    }

    public Integer getUserTopicNum() {
        return userTopicNum;
    }

    public void setUserTopicNum(Integer userTopicNum) {
        this.userTopicNum = userTopicNum;
    }

    public Integer getUserReplyNum() {
        return userReplyNum;
    }

    public void setUserReplyNum(Integer userReplyNum) {
        this.userReplyNum = userReplyNum;
    }
}