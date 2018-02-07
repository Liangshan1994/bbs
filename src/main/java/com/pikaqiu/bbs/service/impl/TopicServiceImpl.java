package com.pikaqiu.bbs.service.impl;

import com.pikaqiu.bbs.dao.TopicMapper;
import com.pikaqiu.bbs.dao.UserInfoMapper;
import com.pikaqiu.bbs.entity.Topic;
import com.pikaqiu.bbs.entity.UserInfo;
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
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<Topic> getTopTopic() {
        List<Topic> topics = topicMapper.getTopTopic();
        setUserInfoToTopic(topics);
        return topics;
    }

    @Override
    public List<Topic> getTopicByBoardId(Integer boardId) {
        List<Topic> topics = topicMapper.selectByBoardId(boardId);
        setUserInfoToTopic(topics);
        return topics;
    }

    private void setUserInfoToTopic(List<Topic> topics) {
        for (Topic topic : topics) {
            UserInfo userInfo = userInfoMapper.get(topic.getUserId());
            topic.setUserInfo(userInfo);
        }
    }

    @Override
    public Topic getTopicById(Integer id) {
        return topicMapper.get(id);
    }

    @Override
    public List<Topic> getNewTopic(Integer size) {
        return topicMapper.getNewTopic(size);
    }

    @Override
    public List<Topic> getEliteTopic(Integer size) {
        return topicMapper.getEliteTopic(size);
    }

}
