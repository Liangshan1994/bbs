package com.pikaqiu.bbs.service.impl;

import com.pikaqiu.bbs.dao.TopicMapper;
import com.pikaqiu.bbs.entity.Topic;
import com.pikaqiu.bbs.service.TopicService;
import com.pikaqiu.common.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lvls on 2018/1/31.
 */
@Service("topicService")
public class TopicServiceImpl extends BaseServiceImpl<TopicMapper,Topic> implements TopicService  {

    @Autowired
    private TopicMapper topicMapper;

    @Override
    public List<Topic> getTopTopic() {
        return topicMapper.getTopTopic();
    }

    @Override
    public List<Topic> getTopicByBoardId(Integer boardId) {
        return topicMapper.selectByBoardId(boardId);
    }

    @Override
    public Topic getTopicById(Integer id) {
        return topicMapper.get(id);
    }
}
