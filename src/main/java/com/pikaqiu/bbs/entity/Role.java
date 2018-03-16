package com.pikaqiu.bbs.entity;

import com.pikaqiu.common.base.BaseEntity;

import java.util.HashSet;
import java.util.Set;

public class Role extends BaseEntity<Role>{

    private String name;

    private String info;

    private Set<User> users = new HashSet<>();

    private Set<Permission> permissions = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}