package com.pikaqiu.bbs.dao;

import com.pikaqiu.bbs.entity.Reply;
import com.pikaqiu.common.base.BaseMapper;

import java.util.List;

public interface ReplyMapper extends BaseMapper<Reply>{
    List<Reply> selectByTopicId(Integer topicId);

    Integer getReplyNumByTopicId(Integer topicId);
}