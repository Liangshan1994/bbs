package com.pikaqiu.common.processor;

import com.pikaqiu.bbs.entity.News;
import com.pikaqiu.bbs.entity.NewsContent;
import com.pikaqiu.bbs.service.NewsContentService;
import com.pikaqiu.bbs.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;
import java.util.Set;

/**
 * info:新闻
 * Created by lvls on 2018/2/22.
 */
@Repository
public class NewsPipeline implements Pipeline {

    private final Logger logger = LoggerFactory.getLogger(NewsPipeline.class);

    @Autowired
    private NewsService newsService;
    @Autowired
    private NewsContentService newsContentService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        save(resultItems.getAll().entrySet());
    }

    private synchronized void save(Set<Map.Entry<String, Object>> entries) {
        for (Map.Entry<String, Object> entry : entries) {
            if (entry.getKey().contains("news")) {
                News news = (News) entry.getValue();
                if(!newsService.isExist(news.getLink())){
                    news.setCreateBy(1);
                    news.setUpdateBy(1);
                    NewsContent newsContent = new NewsContent();
                    newsContent.setContent(news.getContent());
                    newsContentService.insert(newsContent);
                    news.setContentId(newsContent.getId());
                    newsService.insert(news);
                    logger.info(news.getType()+"================save news：" + news.getTitle());
                }else{
                    logger.info("================news isExist：" + news.getTitle());
                    break;
                }
            }
        }
    }

}
