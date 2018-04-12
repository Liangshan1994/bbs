package com.pikaqiu.bbs.entity;

import com.pikaqiu.common.base.BaseEntity;

import java.io.Serializable;

public class NewsContent extends BaseEntity<NewsContent> implements Serializable {

    private static final long serialVersionUID = -8688692949384141472L;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
