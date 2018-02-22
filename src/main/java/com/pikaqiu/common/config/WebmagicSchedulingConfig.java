package com.pikaqiu.common.config;

import com.pikaqiu.common.processor.JianShuProcessor;
import com.pikaqiu.common.processor.NewsPipeline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

import java.util.Date;

/**
 * 新闻定时任务
 * Created by lvls on 2018/2/22.
 */
@Component
public class WebmagicSchedulingConfig {

    private final Logger logger = LoggerFactory.getLogger(WebmagicSchedulingConfig.class);

    @Autowired
    private NewsPipeline newsPipeline;

    /**
     * 简书
     */
    @Scheduled(cron = "0 0 3 * * ? ")//3点触发
    public void jianShuScheduled() {
        logger.info(new Date()+"----开始执行简书定时任务");
        Spider spider = Spider.create(new JianShuProcessor());
        spider.addUrl("http://www.jianshu.com");
        spider.addPipeline(newsPipeline);
        spider.thread(5);
        spider.setExitWhenComplete(true);
        spider.start();
        spider.stop();
        logger.info(new Date()+"----开始执行简书定时任务");
    }
}
