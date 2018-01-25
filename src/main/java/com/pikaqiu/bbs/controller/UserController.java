package com.pikaqiu.bbs.controller;

import com.pikaqiu.bbs.entity.User;
import com.pikaqiu.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lvls on 2018/1/23.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value="/all/{pageNum}/{pageSize}",method = RequestMethod.POST)
    public List<User> findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        return userService.findAllUser(pageNum,pageSize);
    }

    @RequestMapping(value = "/userInfo")
    public String  toUserInfo(int userId){
        return "userInfo";
    }

}
