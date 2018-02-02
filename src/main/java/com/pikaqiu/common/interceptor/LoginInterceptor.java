package com.pikaqiu.common.interceptor;

import com.pikaqiu.common.config.Global;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
/**
 * Created by lvls on 2018/1/26.
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 判断接口是否需要登录
        LoginAuth methodAnnotation = method.getAnnotation(LoginAuth.class);
        // 有 @LoginAuth 注解，需要认证
        HttpSession session = httpServletRequest.getSession();
        if (methodAnnotation != null) {
            //这里是认证的方法
            if(session.getAttribute(Global.SESSION_LOGIN_USER) != null){
                return true;
            }else{
                String url = "/toLogin";
                httpServletResponse.sendRedirect(url);
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
