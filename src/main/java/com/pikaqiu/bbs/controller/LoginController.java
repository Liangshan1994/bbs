package com.pikaqiu.bbs.controller;

import com.pikaqiu.bbs.entity.LoginInfo;
import com.pikaqiu.bbs.entity.User;
import com.pikaqiu.bbs.entity.UserInfo;
import com.pikaqiu.bbs.service.LoginInfoService;
import com.pikaqiu.bbs.service.UserInfoService;
import com.pikaqiu.bbs.service.UserService;
import com.pikaqiu.common.config.Global;
import com.pikaqiu.common.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by lvls on 2018/1/24.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private LoginInfoService loginInfoService;

    @RequestMapping("/toLogin")
    public String toLogin(HttpServletRequest request, Model model) {
        String referer = (String)request.getSession().getAttribute("referer");
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
    public String login(User user,HttpSession session,String headRreferer,HttpServletRequest request){
        user.setPassword(MD5Util.MD5(user.getPassword()+ Global.PWD_STR));
        User loginUser = userService.checkPassword(user);
        if(loginUser!=null){
            UserInfo userInfo = userInfoService.get(loginUser.getId());
            session.setAttribute(Global.SESSION_LOGIN_USER, userInfo);
            LoginInfo loginInfo = new LoginInfo();
            loginInfo.setLoginDate(new Date());
            loginInfo.setLoginIp(getIp(request));
            loginInfo.setUserId(loginUser.getId());
            loginInfoService.insert(loginInfo);
            if(headRreferer!=null){
                return "redirect:" + headRreferer;
            }else{
                String uri = request.getRequestURI();
                String uri2 = uri.replace(request.getContextPath(), "");
                return "redirect:" + uri2;
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
        user.setPassword(MD5Util.MD5(user.getPassword()+Global.PWD_STR));
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

    public String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (ip!=null && ip!="") {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
