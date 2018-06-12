package com.pikaqiu.bbs.utils;

import com.pikaqiu.common.redis.RedisService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * Redis工具类
 * Create by lvls on 2018/4/24
 */
@Component
public class RedisUtil {

    @Resource
    private RedisService redisService1;

    private static RedisService redisService;

    @PostConstruct
    public void init(){
        redisService = redisService1;
    }

    public static boolean set(final String key, final String value) {
        return redisService.set(key,value);
    }

    public static String get(final String key){
        return redisService.get(key);
    }

    public static boolean expire(final String key, long expire) {
        return  redisService.expire(key,expire);
    }

    public static <T> boolean setList(String key, List<T> list) {
        return redisService.setList(key,list);
    }

    public static <T> List<T> getList(String key,Class<T> clz) {
        return redisService.getList(key,clz);
    }

    public static long lpush(final String key, Object obj) {
        return redisService.lpush(key,obj);
    }

    public static long rpush(final String key, Object obj) {
        return redisService.rpush(key,obj);
    }

    public static String lpop(final String key) {
        return redisService.lpop(key);
    }
}
