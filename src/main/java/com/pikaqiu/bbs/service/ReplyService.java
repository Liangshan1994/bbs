package com.pikaqiu.bbs.service;

import com.pikaqiu.bbs.entity.Reply;
import com.pikaqiu.common.base.BaseService;
import com.pikaqiu.common.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by lvls on 2018/2/1.
 */
public interface ReplyService extends BaseService<Reply>{

    List<Reply> selectByTopicId(Integer topicId);

    Integer getReplyNumByTopicId(Integer topicId);

    PageInfo<Reply> selectPageByTopicId(Integer id, Integer pageNo);
}
