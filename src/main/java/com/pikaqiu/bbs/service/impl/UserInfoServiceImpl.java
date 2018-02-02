package com.pikaqiu.bbs.service.impl;

import com.pikaqiu.bbs.dao.UserInfoMapper;
import com.pikaqiu.bbs.entity.UserInfo;
import com.pikaqiu.bbs.service.UserInfoService;
import com.pikaqiu.common.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by lvls on 2018/2/2.
 */
@Service("userInfoService")
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoMapper,UserInfo> implements UserInfoService {
}
