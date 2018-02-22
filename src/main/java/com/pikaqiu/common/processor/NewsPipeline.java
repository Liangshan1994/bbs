package com.pikaqiu.common.processor;

import com.pikaqiu.bbs.entity.News;
import com.pikaqiu.bbs.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;

/**
 * info:新闻
 * Created by lvls on 2018/2/22.
 */
@Repository
public class NewsPipeline  implements Pipeline {

    @Autowired
    private NewsService newsService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            if (entry.getKey().contains("news")) {
                News news = (News) entry.getValue();
                news.setCreateBy(1);
                news.setUpdateBy(1);
                newsService.insert(news);
                System.out.println("测试Process");
            }
        }
    }
}
