package com.pikaqiu.bbs.entity;

import com.pikaqiu.common.base.BaseEntity;

public class NewsContent extends BaseEntity<NewsContent> {

    private Integer newsId;

    private String content;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
