package com.pikaqiu.bbs.controller;

import com.pikaqiu.bbs.entity.User;
import com.pikaqiu.bbs.entity.UserInfo;
import com.pikaqiu.bbs.service.UserInfoService;
import com.pikaqiu.bbs.service.UserService;
import com.pikaqiu.common.config.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lvls on 2018/1/24.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/toRegister")
    public String toRegister(HttpServletRequest request, Model model){
        String referer = request.getRequestURI();
        model.addAttribute("referer",referer);
        return "register";
    }

    @RequestMapping("/login")
    public String login(User user,HttpSession session,HttpServletRequest request,String referer,String loginFrom){
        User user1 = userService.checkPassword(user);
        UserInfo userInfo = userInfoService.get(user1.getId());
        if(user1!=null){
            session.setAttribute(Global.SESSION_LOGIN_USER, userInfo);
            if("header".equals(loginFrom)){
                return "redirect:index";
            }else{
                return "redirect:" + referer;
            }
        }else{
            return "redirect:toLogin";
        }
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute(Global.SESSION_LOGIN_USER);
        return "redirect:index";
    }

    @RequestMapping("/register")
    public String register(User user,String referer){
        userService.save(user);
        if("/toRegister".equals(referer)){
            return "index";
        }else{
            return referer;
        }
    }
}
