package com.pikaqiu.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.pikaqiu.common.pagehelper.PageInfo;
import com.pikaqiu.bbs.dao.ReplyMapper;
import com.pikaqiu.bbs.entity.Reply;
import com.pikaqiu.bbs.service.ReplyService;
import com.pikaqiu.common.base.BaseServiceImpl;
import com.pikaqiu.common.config.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lvls on 2018/2/1.
 */
@Service("replyService")
public class ReplyServiceImpl extends BaseServiceImpl<ReplyMapper,Reply> implements ReplyService{

    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public List<Reply> selectByTopicId(Integer topicId) {
        return replyMapper.selectByTopicId(topicId);
    }

    @Override
    public Integer getReplyNumByTopicId(Integer topicId) {
        return replyMapper.getReplyNumByTopicId(topicId);
    }

    @Override
    public PageInfo<Reply> selectPageByTopicId(Integer topicId, Integer pageNo) {
        PageHelper.startPage(pageNo, Global.PAGE_SIZE);
        List<Reply> replyList = replyMapper.selectPageByTopicId(topicId);
        PageInfo<Reply> pageInfo = new PageInfo<>(replyList);
        return pageInfo;
    }
}
