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
import javax.servlet.http.HttpServletResponse;
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
    public String toLogin(HttpServletRequest request, HttpServletResponse response,Model model) {
        String referer = request.getParameter("referer");
        model.addAttribute("referer",referer);
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
                return "redirect:" + referer==null?"index":referer;
            }
        }else{
            return "toLogin";
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
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(user.getId());
        userInfo.setCreateBy(user.getId());
        userInfo.setUserName(user.getLoginName());
        userInfo.setUpdateBy(user.getId());
        userInfoService.insert(userInfo);
        if("/toRegister".equals(referer)){
            return "index";
        }else{
            return "index";
        }
    }
}
