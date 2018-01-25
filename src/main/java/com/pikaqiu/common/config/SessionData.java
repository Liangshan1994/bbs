package com.pikaqiu.common.config;

/**
 * Created by lvls on 2018/1/25.
 */
public class SessionData {
    private Integer userCode;
    private String mobileNumber;

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setUserCode(Integer userCode) {
        this.userCode = userCode;
    }

    public Integer getUserCode() {
        return userCode;
    }
}
