package com.pikaqiu.bbs.controller;

import com.pikaqiu.bbs.entity.User;
import com.pikaqiu.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String login(User user, Model model){
        User user1 = userService.checkPassword(user);
        if(user1!=null){
            model.addAttribute("user",user1);
            return "redirect:index";
        }else{
            model.addAttribute("message","用户名与密码不匹配");
            return "redirect:login";
        }
    }

    @RequestMapping("/register")
    public String register(User user){
        userService.save(user);
        return null;
    }
}
