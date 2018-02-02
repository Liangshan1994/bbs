package com.pikaqiu.common.base;

import java.util.List;

/**
 * Created by lvls on 2018/2/1.
 */
public interface BaseService<T> {

    T get(Integer id);

    T get(T entity);

    List<T> findList(T entity);

    Page<T> findPage(Page<T> page, T entity);

    void insert(T entity);

    void update(T entity);

    void delete(T entity);

}
