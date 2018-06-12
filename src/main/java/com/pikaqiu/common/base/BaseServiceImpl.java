package com.pikaqiu.common.base;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by lvls on 2018/2/1.
 */
public abstract class BaseServiceImpl<D extends BaseMapper<T>, T extends BaseEntity<T>> implements BaseService<T>{

    /**
     * 持久层对象
     */
    @Autowired
    protected D dao;

    /**
     * 获取单条数据
     */
    public T get(Integer id) {
        return dao.get(id);
    }

    /**
     * 获取单条数据
     */
    public T get(T entity) {
        return dao.get(entity);
    }

    /**
     * 查询列表数据
     */
    public List<T> findList(T entity) {
        return dao.findList(entity);
    }

    /**
     * 查询分页数据
     */
    public Page<T> findPage(Page<T> page, T entity) {
        //entity.setPage(page);
        //page.setList(dao.findList(entity));
        return page;
    }

    /**
     * 保存数据（插入或更新）
     */
    @Transactional(readOnly = false)
    public void insert(T entity) {
        entity.preInsert();
        entity.setDelFlag(0);
        entity.setCreateDate(new Date());
        entity.setUpdateDate(new Date());
        dao.insert(entity);
    }
    /**
     * 保存数据（插入或更新）
     */
    @Transactional(readOnly = false)
    public void update(T entity) {
        entity.preUpdate();
        dao.update(entity);
    }

    /**
     * 删除数据
     */
    @Transactional(readOnly = false)
    public void delete(T entity) {
        dao.delete(entity);
    }

}

