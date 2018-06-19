package com.pikaqiu.common.websocket;

import com.pikaqiu.common.base.BaseEntity;

/**
 * @author 吕梁山
 * @date 2018/6/12
 */
public class MessageVO extends BaseEntity<MessageVO>{

    private int type;
    private int userNum;
    private String message;
    private String sessionId;
    private String userName;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
