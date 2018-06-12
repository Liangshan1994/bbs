package com.pikaqiu.bbs.dao;

import com.pikaqiu.common.base.BaseMapper;
import com.pikaqiu.bbs.entity.Dict;
import com.pikaqiu.common.base.BaseMapper;
import com.pikaqiu.common.base.BaseMapper;

import java.util.List;

public interface DictMapper extends BaseMapper<Dict> {
    List<Dict> getDicByType(String type);
    Integer getMaxValueByType(String type);
}