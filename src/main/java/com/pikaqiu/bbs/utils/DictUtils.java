package com.pikaqiu.bbs.utils;

import com.pikaqiu.bbs.dao.DictMapper;
import com.pikaqiu.bbs.entity.Dict;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 字典工具
 * Create by lvls on 2018/3/23
 */
@Component
public class DictUtils {

    @Resource
    private DictMapper dictMapper1;

    private static DictMapper dictMapper;

    public static final String CACHE_DICT_MAP = "dictMap";

    @PostConstruct
    public void init() {
        dictMapper = dictMapper1;
    }

    public static List<Dict> dictAllList = null;


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

    public static Integer getDictValue(String label, String type, Integer defaultLabel){
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)){
            for (Dict dict : getDictList(type)){
                if (type.equals(dict.getType()) && label.equals(dict.getLabel())){
                    return dict.getValue();
                }
            }
        }
        return defaultLabel;
    }

    public static Integer getDictValue(String label, String type){
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)){
            for (Dict dict : getDictList(type)){
                if (type.equals(dict.getType()) && label.equals(dict.getLabel())){
                    return dict.getValue();
                }
            }
        }
        return 0;
    }

    /**
     * 根据type获取该类的所有字典数据
     * @param type
     * @return
     */
    public static List<Dict> getDictList(String type){
        if(dictAllList==null){
            dictAllList = dictMapper.findAllList();
        }
        List<Dict> dictList = new ArrayList<>();
        for (Dict dict : dictAllList) {
            if(StringUtils.equals(type,dict.getType())){
                dictList.add(dict);
            }
        }
        if (dictList == null){
            dictList = Lists.newArrayList();
        }
        return dictList;
    }

    /**
     * 查询该label是否已存在
     * @param type
     * @return
     */
    public static boolean isLabelExistByType(String label,String type) {
        List<Dict> dictList = dictMapper.getDicByType(type);
        for (Dict dict : dictList) {
            if(StringUtils.equals(label,dict.getLabel())){
                return true;
            }
        }
        return false;
    }

    public static int getMaxValueByType(String type) {
        return dictMapper.getMaxValueByType(type);
    }

    public static void saveDict(Dict dict){
        dict.setCreateBy(1);
        dict.setCreateDate(new Date());
        dict.setUpdateBy(1);
        dict.setUpdateDate(new Date());
        dict.setDelFlag(0);
        dictMapper.insert(dict);
    }

    public static void reflushDict(){
        dictAllList = null;
    }
}
