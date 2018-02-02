package com.pikaqiu.common.base;

import java.util.List;

/**
 * Created by lvls on 2018/2/1.
 */
public interface BaseMapper<T> {

    /**
     * 根据id查询单条数据
     */
    T get(Integer id);

    /**
     * 根据实体类查询单条数据
     */
    T get(T entity);

    /**
     * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
     */
    List<T> findList(T entity);

    /**
     * 查询所有数据列表
     */
    List<T> findAllList(T entity);

    /**
     * 查询所有数据列表
     */
    List<T> findAllList();

    /**
     * 插入数据
     */
    int insert(T entity);

    /**
     * 更新数据
     */
    int update(T entity);

    /**
     * 删除数据（一般为逻辑删除，更新del_flag字段为1）
     */
    int delete(String id);

    /**
     * 删除数据（一般为逻辑删除，更新del_flag字段为1）
     */
    int delete(T entity);

}
