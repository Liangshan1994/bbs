package com.pikaqiu.common.utils;

import com.pikaqiu.bbs.dao.DictMapper;
import com.pikaqiu.bbs.entity.Dict;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典工具
 * Create by lvls on 2018/3/23
 */
@Component
public class DictUtils {

    @Autowired
    private static DictMapper dictMapper;

    public static final String CACHE_DICT_MAP = "dictMap";

    public static String getDictLabel(String value, String type, String defaultValue){
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(value)){
            for (Dict dict : getDictList(type)){
                if (type.equals(dict.getType()) && value.equals(dict.getValue())){
                    return dict.getLabel();
                }
            }
        }
        return defaultValue;
    }

    public static String getDictLabels(String values, String type, String defaultValue){
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(values)){
            List<String> valueList = Lists.newArrayList();
            for (String value : StringUtils.split(values, ",")){
                valueList.add(getDictLabel(value, type, defaultValue));
            }
            return StringUtils.join(valueList, ",");
        }
        return defaultValue;
    }

    public static String getDictValue(String label, String type, String defaultLabel){
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)){
            for (Dict dict : getDictList(type)){
                if (type.equals(dict.getType()) && label.equals(dict.getLabel())){
                    return dict.getValue();
                }
            }
        }
        return defaultLabel;
    }

    public static List<Dict> getDictList(String type){
        @SuppressWarnings("unchecked")
//        Map<String, List<Dict>> dictMap = (Map<String, List<Dict>>)CacheUtils.get(CACHE_DICT_MAP);
                Map<String, List<Dict>> dictMap = new HashMap();
//        if (dictMap==null){
//            dictMap = new HashMap();
        for (Dict dict : dictMapper.findAllList(new Dict())){
            List<Dict> dictList = dictMap.get(dict.getType());
            if (dictList != null){
                dictList.add(dict);
            }else{
                dictMap.put(dict.getType(), Lists.newArrayList(dict));
            }
//            }
//            CacheUtils.put(CACHE_DICT_MAP, dictMap);
        }
        List<Dict> dictList = dictMap.get(type);
        if (dictList == null){
            dictList = Lists.newArrayList();
        }
        return dictList;
    }

    /**
     * 返回字典列表（JSON）
     * @param type
     * @return
     */
//    public static String getDictListJson(String type){
//        return JsonMapper.toJsonString(getDictList(type));
//    }
}
