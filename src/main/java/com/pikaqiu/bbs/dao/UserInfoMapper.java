package com.pikaqiu.bbs.dao;

import com.pikaqiu.bbs.entity.UserInfo;
import com.pikaqiu.common.base.BaseMapper;

import java.util.List;

public interface UserInfoMapper extends BaseMapper<UserInfo>{

    List<UserInfo> getActiveUser(Integer size);
}