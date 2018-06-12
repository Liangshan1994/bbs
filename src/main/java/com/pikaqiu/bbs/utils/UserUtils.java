package com.pikaqiu.bbs.utils;

import com.pikaqiu.bbs.entity.UserInfo;
import com.pikaqiu.common.config.Global;
import com.pikaqiu.bbs.entity.UserInfo;
import com.pikaqiu.common.config.Global;
import com.pikaqiu.bbs.entity.UserInfo;
import com.pikaqiu.common.config.Global;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lvls on 2018/2/1.
 */
public class UserUtils {

    public static UserInfo getUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserInfo loginUser = (UserInfo)session.getAttribute(Global.SESSION_LOGIN_USER);
        return loginUser;
    }
}
