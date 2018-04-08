package com.pikaqiu.common.Scheduled;

import com.pikaqiu.common.processor.ItHomeProcessor;
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
        logger.info(new Date()+"=====Start JianShu =====");
        for (int i = 1; i < 11; i++) {
            createJianShuSpider("https://www.jianshu.com/c/V2CqjW?order_by=added_at&page="+i);
        }
        logger.info(new Date()+"=====End JianShu =====");
    }

    public void createJianShuSpider(String url){
        Spider spider = Spider.create(new JianShuProcessor());
        spider.addUrl(url);
        spider.addPipeline(newsPipeline);
        spider.thread(5);
        spider.setExitWhenComplete(true);
        spider.start();
        spider.stop();
    }

    /**
     * IT之家
     */
    @Scheduled(cron = "0 0 0/1 * * ? ")
    public void itHomeScheduled() {
        logger.info(new Date()+"=====Start ItHome =====");
        Spider spider = Spider.create(new ItHomeProcessor());
        spider.addUrl("https://www.ithome.com/");
        spider.addPipeline(newsPipeline);
        spider.thread(1);
        spider.setExitWhenComplete(true);
        spider.start();
        spider.stop();
        logger.info(new Date()+"=====End ItHome =====");
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
