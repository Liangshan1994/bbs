package com.pikaqiu.bbs.controller;

import com.pikaqiu.bbs.entity.UserInfo;
import com.pikaqiu.bbs.service.UserInfoService;
import com.pikaqiu.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lvls on 2018/1/23.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/home-{userId}.html")
    public String  toUserInfo(@PathVariable("userId") int userId,HttpServletRequest request,Model model) {
        //访问对象
        UserInfo homeUser = userInfoService.get(userId);
        model.addAttribute("homeUser",homeUser);
        return "home";
    }

    @ResponseBody
    @RequestMapping("getActiveUser")
    public List<UserInfo> getActiveUser(){
        return userInfoService.getActiveUser();
    }

}
