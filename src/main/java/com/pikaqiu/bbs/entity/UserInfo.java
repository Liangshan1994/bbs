package com.pikaqiu.bbs.entity;

import com.pikaqiu.common.base.BaseEntity;

import java.util.Date;

public class UserInfo extends BaseEntity<UserInfo>{

    private Integer userId;

    private String userName;

    private Integer userSex;

    private String userQq;

    private String userWx;

    private String userHeadImg;

    private Date userBirthDate;

    private String userBlog;

    private Integer userProvince;

    private Integer userCity;

    private Integer userArea;

    private String userAddress;

    private Integer userGradeid;

    private String userSign;

    private Integer userTopicNum;

    private Integer userReplyNum;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq == null ? null : userQq.trim();
    }

    public String getUserWx() {
        return userWx;
    }

    public void setUserWx(String userWx) {
        this.userWx = userWx == null ? null : userWx.trim();
    }

    public String getUserHeadImg() {
        return userHeadImg;
    }

    public void setUserHeadImg(String userHeadImg) {
        this.userHeadImg = userHeadImg == null ? null : userHeadImg.trim();
    }

    public Date getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(Date userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public String getUserBlog() {
        return userBlog;
    }

    public void setUserBlog(String userBlog) {
        this.userBlog = userBlog == null ? null : userBlog.trim();
    }

    public Integer getUserProvince() {
        return userProvince;
    }

    public void setUserProvince(Integer userProvince) {
        this.userProvince = userProvince;
    }

    public Integer getUserCity() {
        return userCity;
    }

    public void setUserCity(Integer userCity) {
        this.userCity = userCity;
    }

    public Integer getUserArea() {
        return userArea;
    }

    public void setUserArea(Integer userArea) {
        this.userArea = userArea;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public Integer getUserGradeid() {
        return userGradeid;
    }

    public void setUserGradeid(Integer userGradeid) {
        this.userGradeid = userGradeid;
    }

    public String getUserSign() {
        return userSign;
    }

    public void setUserSign(String userSign) {
        this.userSign = userSign == null ? null : userSign.trim();
    }

    public Integer getUserTopicNum() {
        return userTopicNum;
    }

    public void setUserTopicNum(Integer userTopicNum) {
        this.userTopicNum = userTopicNum;
    }

    public Integer getUserReplyNum() {
        return userReplyNum;
    }

    public void setUserReplyNum(Integer userReplyNum) {
        this.userReplyNum = userReplyNum;
    }
}