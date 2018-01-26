package com.pikaqiu.bbs.controller;

import com.pikaqiu.bbs.entity.User;
import com.pikaqiu.bbs.service.UserService;
import com.pikaqiu.common.config.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by lvls on 2018/1/24.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(User user,HttpSession session){
        User user1 = userService.checkPassword(user);
        if(user1!=null){
            session.setAttribute(WebSecurityConfig.SESSION_KEY, user1);
            return "redirect:index";
        }else{
            return "redirect:login";
        }
    }

    @RequestMapping("/register")
    public String register(User user){
        userService.save(user);
        return null;
    }
}
