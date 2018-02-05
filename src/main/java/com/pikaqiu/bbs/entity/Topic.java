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
}