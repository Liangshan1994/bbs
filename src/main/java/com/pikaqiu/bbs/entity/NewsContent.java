package com.pikaqiu.bbs.entity;

import com.pikaqiu.common.base.BaseEntity;

public class NewsContent extends BaseEntity<NewsContent> {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
