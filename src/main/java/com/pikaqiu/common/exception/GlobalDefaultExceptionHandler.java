package com.pikaqiu.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lvls on 2018/1/29.
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    /**
     * 统一异常处理
     *
     * @param exception
     *            exception
     * @return
     */
//    @ExceptionHandler({ Exception.class })
//    @ResponseStatus(HttpStatus.OK)
//    public ModelAndView processException(HttpServletRequest request ,RuntimeException exception) {
//        logger.error("Request: " + request.getRequestURL() + " raised " + exception);
//        ModelAndView m = new ModelAndView();
//        m.addObject("roncooException", exception.getMessage());
//        m.addObject("url", request.getRequestURL());
//        m.setViewName("error/error");
//        return m;
//    }

}
