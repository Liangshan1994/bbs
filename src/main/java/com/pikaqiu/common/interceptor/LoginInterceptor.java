package com.pikaqiu.common.interceptor;

import com.pikaqiu.common.config.SessionData;
import com.pikaqiu.common.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

import static com.pikaqiu.common.utils.Constants.*;

/**
 * Created by lvls on 2018/1/25.
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private RedisUtil redisUtil;
    private final static String SESSION_KEY_PREFIX = "session:";

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        if (!handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            return true;
        }
        handlerSession(request);

        final HandlerMethod handlerMethod = (HandlerMethod) handler;
        final Method method = handlerMethod.getMethod();
        final Class<?> clazz = method.getDeclaringClass();
        if (clazz.isAnnotationPresent(Auth.class) ||
                method.isAnnotationPresent(Auth.class)) {
            if (request.getAttribute(USER_CODE_SESSION_KEY) == null) {

                throw new Exception();

            } else {
                return true;
            }
        }

        return true;

    }

    public void handlerSession(HttpServletRequest request) {
        String sessionId = request.getHeader(SESSION_KEY);
        if (sessionId == "" || sessionId == null) {
            sessionId = (String) request.getSession().getAttribute(SESSION_KEY);
        } else {
            SessionData model = (SessionData) redisUtil.get(SESSION_KEY_PREFIX + sessionId);
            if (model == null) {
                return;
            }
            request.setAttribute(SESSION_KEY, sessionId);
            Integer userCode = model.getUserCode();
            if (userCode != null) {
                request.setAttribute(USER_CODE_SESSION_KEY, Long.valueOf(userCode));
            }
            String mobile = model.getMobileNumber();
            if (mobile != null) {
                request.setAttribute(MOBILE_NUMBER_SESSION_KEY, mobile);
            }
        }
        return;
    }
}
