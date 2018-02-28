package com.pikaqiu.common.websocket;

/**
 * Created by lvls on 2018/2/27.
 */
public class MessageVO {
    private Integer type;
    private Integer userNum;
    private String message;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
