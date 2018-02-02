package com.pikaqiu.bbs.service;

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

}
