package com.pikaqiu.bbs.service;

import com.pikaqiu.common.pagehelper.PageInfo;
import com.pikaqiu.bbs.entity.Topic;
import com.pikaqiu.common.base.BaseService;

import java.util.List;

/**
 * Created by lvls on 2018/1/31.
 */
public interface TopicService extends BaseService<Topic> {
    List<Topic> getTopTopic();

    List<Topic> getTopicByBoardId(Integer boardId);

    Topic getTopicById(Integer id);

    List<Topic> getNewTopic();

    List<Topic> getEliteTopic();

    PageInfo<Topic> getPageTopicByBoardId(Integer id, Integer pageNo);

    List<Topic> getTopTopicByBoard(Integer id);
}
