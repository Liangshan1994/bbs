package com.pikaqiu.common.processor;

import com.pikaqiu.bbs.entity.News;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

/**
 * 36氪首页
 * Created by lvls on 2018/2/26.
 */
public class KeProcessor implements PageProcessor {

    private Site site = Site.me()
            .setSleepTime(100)
            .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");

    public static final String list = "http://36kr.com/";
    public static final String contentLink = "http://36kr.com/p/";

    @Override
    public void process(Page page) {
        if (page.getUrl().regex(contentLink).match()) {
            Selectable xpath = page.getHtml().xpath("//div[@class='mobile_article'][1]");
            String title = xpath.xpath("//h1[1]/text()").toString();
            String author = xpath.xpath("//div[@class='author am-fl']/span[@class='name']/text()").toString();
            String type = xpath.xpath("//div[@class='author am-fl']/abbr[@class='time'][last()]/text()").toString();
            String info = xpath.xpath("//section[@class='summary']/text()").toString();
            String content = xpath.xpath("//section[@class='textblock']/node()").toString();
            News news = new News();
            news.setAuthor(author);
            news.setInfo(info);
            news.setType(type);
            news.setSource(2);
            news.setContent(content);
            news.setLink(page.getRequest().getUrl());
            news.setTitle(title);
            page.putField("news"+title, news);
        }else if(page.getUrl().regex(list).match()){
            List<Selectable> list = page.getHtml().xpath("//div[@class='kr_article_list']").nodes();
            System.out.println(page.getHtml().toString());
            for (Selectable s : list) {
                String link = s.xpath("//div/a[1]").links().toString();
                page.addTargetRequest(new Request(link));
            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

}
