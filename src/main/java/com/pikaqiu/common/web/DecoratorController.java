package com.pikaqiu.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lvls on 2018/1/29.
 */
@Controller
@RequestMapping("/decorator")
public class DecoratorController {
    @RequestMapping("default")
    public String defaultDecorator() {
        return "/decorator/default";
    }
}
