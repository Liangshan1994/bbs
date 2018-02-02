package com.pikaqiu.bbs.service;

import com.pikaqiu.bbs.entity.UserInfo;
import com.pikaqiu.common.base.BaseService;

import java.util.List;

/**
 * Created by lvls on 2018/2/2.
 */
public interface UserInfoService extends BaseService<UserInfo>{

    List<UserInfo> getActiveUser(Integer size);
}
