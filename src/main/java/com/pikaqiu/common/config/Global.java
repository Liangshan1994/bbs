package com.pikaqiu.common.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by lvls on 2018/1/26.
 */
public class Global {
    /**
     * session中登录用户的key
     */
    public static final String SESSION_LOGIN_USER = "loginUser";

    /**
     * 首页显示的pageSize
     */
    public static final Integer INDEX_PAGE_SIZE = 10;

    /**
     * 主题的pageSize
     */
    public static final Integer PAGE_SIZE = 20;

    /**
     * 首页版块的pageSize
     */
    public static final Integer INDEX_BOARD_SIZE = 5;

    /**
     * 版块列表的pageSize
     */
    public static final Integer BOARD_SIZE = 10;
    /**
     * 新闻列表的pageSize
     */
    public static final Integer NEWS_SIZE = 10;
}
