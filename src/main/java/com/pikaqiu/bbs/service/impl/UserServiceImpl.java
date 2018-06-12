package com.pikaqiu.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.pikaqiu.bbs.dao.UserMapper;
import com.pikaqiu.common.base.BaseServiceImpl;
import com.pikaqiu.bbs.dao.UserMapper;
import com.pikaqiu.bbs.entity.User;
import com.pikaqiu.bbs.service.UserService;
import com.pikaqiu.common.base.BaseServiceImpl;
import com.pikaqiu.bbs.dao.UserMapper;
import com.pikaqiu.common.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lvls on 2018/1/23.
 */
@Service(value = "userService")
public class UserServiceImpl extends BaseServiceImpl<UserMapper,User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int save(User user) {

        return userMapper.insert(user);
    }
    /*
    * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
    * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    * pageNum 开始页数
    * pageSize 每页显示的数据条数
    * */
    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAllUser();
    }

    @Override
    public User checkPassword(User user) {
        return userMapper.checkPassword(user);
    }

    @Override
    public User findRoleByLoginName(String loginName) {
        return userMapper.findRoleByLoginName(loginName);
    }
}
