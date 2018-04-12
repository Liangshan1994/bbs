package com.pikaqiu.common.processor;

import com.pikaqiu.bbs.entity.Dict;
import com.pikaqiu.bbs.entity.News;
import com.pikaqiu.bbs.utils.DictUtils;
import com.pikaqiu.bbs.utils.NewsUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Create by lvls on 2018/4/8
 */
public class ItHomeProcessor implements PageProcessor {

    private Site site = Site.me()
            .setSleepTime(100)
            .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
    private static final String itHomeLink = "https://www.ithome.com/";
    private static final String topicLink = "https://www.ithome.com/html/";
    private static final String NEWS_TYPE = "news_type";

    @Override
    public void process(Page page) {

        if(page.getUrl().regex(topicLink).match()){
            List<Selectable> nodes = page.getHtml().xpath("//div[@class='current_nav']/a/text()").nodes();
            String type_label = nodes.get(nodes.size() - 2).toString();
            if(type_label.contains("之家")){
                type_label.replace("之家","");
            }
            String title = page.getHtml().xpath("//div[@class='post_title']/h1/text()").toString();
            String pushTime = page.getHtml().xpath("//span[@id='pubtime_baidu']/text()").toString();
            String author = page.getHtml().xpath("//span[@id='author_baidu']/strong/text()").toString();
            String content = page.getHtml().xpath("//div[@id='paragraph']/html()").toString();
            String info = page.getHtml().xpath("//div[@id='paragraph']/allText()").toString();
            List<String> allLink = NewsUtils.getAllLink();
            boolean contains = allLink.contains(page.getUrl().toString());
            if(!contains) {
                int type_value = 0;
                //查询该类是否已在字典表中存在
                boolean bool = DictUtils.isLabelExistByType(type_label, NEWS_TYPE);
                //如果不存在，则新建一个
                if (!bool) {
                    List<Dict> dictList = DictUtils.getDictList(NEWS_TYPE);
                    String dict_type = dictList.get(0).getType();
                    String dict_description = dictList.get(0).getDescription();
                    type_value = DictUtils.getMaxValueByType(NEWS_TYPE) + 1;
                    Dict dict = new Dict();
                    dict.setValue(type_value);
                    dict.setDescription(dict_description);
                    dict.setLabel(type_label);
                    dict.setType(dict_type);
                    dict.setSort(type_value * 10);
                    DictUtils.saveDict(dict);
                    //新增后刷新字典表
                    DictUtils.reflushDict();
                } else {
                    type_value = DictUtils.getDictValue(type_label, NEWS_TYPE);
                }
                //新建一个新闻对象
                News news = new News();
                news.setLink(page.getUrl().toString());
                news.setAuthor(author);
                news.setSource(2);
                news.setContent(content);
                news.setInfo(info.length() > 100 ? info.substring(0, 100) : info);
                news.setTitle(title);
                news.setType(type_value);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                try {
                    news.setPushDate(sdf.parse(pushTime));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                page.putField("news" + title, news);
            }
        }else if(page.getUrl().regex(itHomeLink).match()){
            List<Selectable> xpath = page.getHtml().xpath("//div[@class='new-list']/div").nodes();
            List<Selectable> selectables = xpath.subList(0, xpath.size() - 2);
            NewsUtils.resetList();
            for (Selectable selectable : selectables) {
                List<Selectable> ul = selectable.xpath("//ul/li[@class!='top']").nodes();
                for (Selectable li : ul) {
                    String date = li.xpath("//span/text()").toString();
                    String link = li.xpath("//span[@class='title']/a").links().toString();
                    if(!"广告".equals(date)){
                        page.addTargetRequest(new Request(link));
                    }
                }
            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}
