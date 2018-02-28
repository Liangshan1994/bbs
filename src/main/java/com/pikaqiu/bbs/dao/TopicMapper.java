package com.pikaqiu.bbs.dao;

import com.pikaqiu.bbs.entity.Topic;
import com.pikaqiu.common.base.BaseMapper;

import java.util.List;

public interface TopicMapper extends BaseMapper<Topic>{

    List<Topic> selectByBoardId(Integer boardId);

    List<Topic> getTopTopic();

    List<Topic> getNewTopic();

    List<Topic> getEliteTopic();

    List<Topic> getTopTopicByBoard(Integer boardId);
}