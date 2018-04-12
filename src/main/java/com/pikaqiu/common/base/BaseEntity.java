package com.pikaqiu.common.base;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lvls on 2018/1/31.
 */
public class BaseEntity<T>{

    private Integer id;

    private Integer createBy;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date createDate;

    private Integer updateBy;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date updateDate;

    private Integer delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsert(){
        this.updateDate = new Date();
        this.createDate = new Date();
        this.delFlag = 0;
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    public void preUpdate(){
        this.updateDate = new Date();
    }
}
