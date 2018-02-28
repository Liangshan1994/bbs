package com.pikaqiu.common.Scheduled;

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
    @Scheduled(cron = "0 0 0/1 * * ? ")
    public void jianShuScheduled() {
        logger.info(new Date()+"----执行简书定时任务开始");
        Spider spider = Spider.create(new JianShuProcessor());
        spider.addUrl("http://www.jianshu.com");
        spider.addPipeline(newsPipeline);
        spider.thread(5);
        spider.setExitWhenComplete(true);
        spider.start();
        spider.stop();
        logger.info(new Date()+"----执行简书定时任务结束");
    }
    /**
     * 36氪
     */
//    @Scheduled(cron = "0 0/2 10-11 * * ? ")
//    public void keScheduled() {
//        logger.info(new Date()+"----执行36氪定时任务开始");
//        Spider spider = Spider.create(new JianShuProcessor());
//        spider.addUrl("http://36kr.com/");
//        spider.addPipeline(newsPipeline);
//        spider.thread(5);
//        spider.setExitWhenComplete(true);
//        spider.start();
//        spider.stop();
//        logger.info(new Date()+"----执行36氪定时任务结束");
//    }
}
