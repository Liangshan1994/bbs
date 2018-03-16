package com.pikaqiu.bbs.dao;

import com.pikaqiu.bbs.entity.User;
import com.pikaqiu.common.base.BaseMapper;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<User> selectAllUser();

    User checkPassword(User user);

    User findRoleByLoginName(String loginName);
}