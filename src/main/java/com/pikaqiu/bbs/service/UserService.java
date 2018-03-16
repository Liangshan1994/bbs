package com.pikaqiu.bbs.service;

import com.pikaqiu.bbs.entity.User;
import com.pikaqiu.common.base.BaseService;

import java.util.List;

/**
 * Created by lvls on 2018/1/23.
 */
public interface UserService extends BaseService<User>{
    int save(User user);
    List<User> findAllUser(int pageNum, int pageSize);
    User checkPassword(User user);
    User findRoleByLoginName(String loginName);
}
