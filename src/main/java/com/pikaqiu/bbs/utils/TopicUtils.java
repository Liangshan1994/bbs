package com.pikaqiu.bbs.utils;

import com.pikaqiu.bbs.entity.Topic;
import com.pikaqiu.bbs.entity.Topic;
import com.pikaqiu.bbs.entity.Topic;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by lvls on 2018/2/27.
 */
public class TopicUtils {

    public static Integer getToDayTopicNum(List<Topic> topics){
        int toDayTopicNum = 0;
        for (Topic topic : topics) {
            if(DateUtils.isSameDay(new Date(),topic.getCreateDate())){
                toDayTopicNum++;
            }
        }
        return toDayTopicNum;
    }

    public static Integer getLastDayTopicNum(List<Topic> topics) {
        int lastDayTopicNum = 0;
        for (Topic topic : topics) {
            Date date = DateUtils.addDays(topic.getCreateDate(), 1);
            if(DateUtils.isSameDay(new Date(),date)){
                lastDayTopicNum++;
            }
        }
        return lastDayTopicNum;
    }
}
