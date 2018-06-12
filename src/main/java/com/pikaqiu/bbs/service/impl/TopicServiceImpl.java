package com.pikaqiu.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.pikaqiu.bbs.dao.TopicMapper;
import com.pikaqiu.bbs.dao.UserInfoMapper;
import com.pikaqiu.bbs.entity.Topic;
import com.pikaqiu.bbs.entity.UserInfo;
import com.pikaqiu.bbs.service.TopicService;
import com.pikaqiu.common.base.BaseServiceImpl;
import com.pikaqiu.common.config.Global;
import com.pikaqiu.common.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
    public List<Topic> getNewTopic() {
        PageHelper.startPage(0, Global.INDEX_PAGE_SIZE);
        List<Topic> newTopic = topicMapper.getNewTopic();
        return newTopic;
    }

    @Override
    public List<Topic> getEliteTopic() {
        PageHelper.startPage(0,Global.INDEX_PAGE_SIZE);
        List<Topic> eliteTopic = topicMapper.getEliteTopic();
        return eliteTopic;
    }

    @Override
    public PageInfo<Topic> getPageTopicByBoardId(Integer boardId, Integer pageNo) {
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(pageNo, Global.PAGE_SIZE);
        List<Topic> topics = topicMapper.selectByBoardId(boardId);
        PageInfo<Topic> pageInfo = new PageInfo<>(topics);
        return pageInfo;
    }

    @Override
    public List<Topic> getTopTopicByBoard(Integer id) {
        PageHelper.startPage(0,Global.INDEX_PAGE_SIZE);
        List<Topic> topTopicByBoard = topicMapper.getTopTopicByBoard(id);
        setUserInfoToTopic(topTopicByBoard);
        return topTopicByBoard;
    }

    @Cacheable(cacheNames ="findListTestRedis",keyGenerator = "wiselyKeyGenerator")//在redis中开启key为findAllUser开头的存储空间
    @Override
    public List<Topic> findListTestRedis() {
        System.out.println("打印语句则没有走缓存");
        List<Topic> list = topicMapper.getNewTopic();
        return list;
    }

}
