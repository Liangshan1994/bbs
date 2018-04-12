package com.pikaqiu.bbs.entity;

import com.pikaqiu.common.base.BaseEntity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User extends BaseEntity<User> implements Serializable {

    private static final long serialVersionUID = 4576559585313999221L;
    private String loginName;//登录名

    private String password;//密码

    private String userPhone;//用户手机

    private String userEmail;//用户邮箱

    private Integer userRoleId;

    private Set<Role> roles = new HashSet<>();

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}