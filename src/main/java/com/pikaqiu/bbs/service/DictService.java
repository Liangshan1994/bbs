package com.pikaqiu.bbs.service;

import com.pikaqiu.bbs.entity.Dict;
import com.pikaqiu.common.base.BaseService;

import java.util.List;

public interface DictService extends BaseService<Dict>{

    String getLabel(String value,String type);

    List<Dict> getDicMap(String type);
}
