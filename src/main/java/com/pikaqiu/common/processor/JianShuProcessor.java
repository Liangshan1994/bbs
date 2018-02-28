package com.pikaqiu.common.processor;

import com.pikaqiu.bbs.entity.News;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 简书首页
 * Created by lvls on 2018/2/22.
 */
public class JianShuProcessor implements PageProcessor {

    private Site site = Site.me()
            .setSleepTime(100)
            .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");

    public static final String list = "http://www.jianshu.com";
    public static final String contentLink = "http://www.jianshu.com/p/";

    @Override
    public void process(Page page) {
        if (page.getUrl().regex(contentLink).match()) {
            Selectable xpath = page.getHtml().xpath("//div[@class='article']");
            String title = xpath.xpath("//h1[@class='title']/text()").toString();
            String author = xpath.xpath("//span[@class='name']/a/text()").toString();
            String pushDate = xpath.xpath("//span[@class='publish-time']/text()").toString().replace("*","");
            String content = xpath.xpath("//div[@class='show-content-free']").toString();
            News news = new News();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
            Date parse = new Date();
            try {
                parse = sdf.parse(pushDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            news.setPushDate(parse);
            news.setAuthor(author);
            news.setSource(1);
            news.setContent(content);
            news.setLink(page.getRequest().getUrl());
            news.setTitle(title);
            page.putField("news"+title, news);
        }else if(page.getUrl().regex(list).match()){
            List<Selectable> list = page.getHtml().xpath("//ul[@class='note-list']/li").nodes();
            for (Selectable s : list) {
                String link = s.xpath("//div/a[@class='title']").links().toString();
                page.addTargetRequest(new Request(link));
            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

//    public static void main(String[] args) {
//        Spider spider = Spider.create(new JianShuProcessor());
//        spider.addUrl("http://www.jianshu.com");
//        spider.addPipeline(new NewsPipeline());
//        spider.thread(5);
//        spider.setExitWhenComplete(true);
//        spider.start();
//    }
}
