package com.pikaqiu.bbs.service.impl;

import com.pikaqiu.bbs.dao.DictMapper;
import com.pikaqiu.bbs.entity.Dict;
import com.pikaqiu.bbs.service.DictService;
import com.pikaqiu.common.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by lvls on 2018/3/23
 */
@Service("dictService")
public class DictServiceImpl extends BaseServiceImpl<DictMapper,Dict> implements DictService {

    @Autowired
    private DictMapper dictMapper;

    @Override
    public String getLabel(String value,String type){
        List<Dict> dicMap = getDicMap(type);
        if(dicMap!=null && dicMap.size()>0){
            for (Dict dict : dicMap) {
                if(value.equals(dict.getValue())){
                    return dict.getLabel();
                }
            }
        }
        return null;
    }

    @Override
    public List<Dict> getDicMap(String type) {
        List<Dict> dictList = dictMapper.getDicByType(type);
        return dictList;
    }

}
