package com.pikaqiu.common.interceptor;

import java.lang.annotation.*;

/**
 * Created by lvls on 2018/1/25.
 * 在类或方法上添加@Auth就验证登录
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Auth {
}
