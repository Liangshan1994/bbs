package com.pikaqiu.common.processor;

import com.pikaqiu.bbs.entity.News;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

/**
 * 简书首页
 * Created by lvls on 2018/2/22.
 */
public class JianShuProcessor implements PageProcessor {

    private Site site = Site.me()
            .setDomain("jianshu.com")
            .setSleepTime(100)
            .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");

    public static final String list = "http://www.jianshu.com";

    @Override
    public void process(Page page) {
        if (page.getUrl().regex(list).match()) {
            List<Selectable> list = page.getHtml().xpath("//ul[@class='note-list']/li").nodes();
            for (Selectable s : list) {
                String title = s.xpath("//div/a[@class='title']/text()").toString();
                String info = s.xpath("//div/p[@class='abstract']/text()").toString();
                String type = s.xpath("//div/a[@class='collection-tag']/text()").toString();
                String link = s.xpath("//div/").links().toString();
                String author = s.xpath("//div/a[@class='nickname']/text()").toString();
                News news = new News();
                news.setAuthor(author);
                news.setSource(1);
                news.setLink(link);
                news.setInfo(info);
                news.setType(type);
                news.setTitle(title);
                page.putField("news"+title, news);
            }
            System.out.println("爬了"+list.size()+"条数据");
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider spider = Spider.create(new JianShuProcessor());
        spider.addUrl("http://www.jianshu.com");
        spider.addPipeline(new NewsPipeline());
        spider.thread(5);
        spider.setExitWhenComplete(true);
        spider.start();
    }
}
