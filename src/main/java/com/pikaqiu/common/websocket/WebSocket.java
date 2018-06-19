package com.pikaqiu.common.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pikaqiu.bbs.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author 吕梁山
 * @date 2018/6/12
 */
@Component
@ServerEndpoint("/webSocket/{userName}")
public class WebSocket {

    private Session session;

    private Logger log = LoggerFactory.getLogger(WebSocket.class);

    private static CopyOnWriteArraySet<WebSocket> webSockets = new CopyOnWriteArraySet<>();

    private MessageVO messageVO = new MessageVO();

    @OnOpen
    public void onOpen(Session session,@PathParam("userName") String username) throws Exception{
        this.session = session;
        webSockets.add(this);
        messageVO.setType(1);
        messageVO.setUserNum(webSockets.size());
        messageVO.setMessage("有新的连接");
        messageVO.setSessionId(this.session.getId());
        String s = new String(username.getBytes("iso8859-1"), "utf-8");
        messageVO.setUserName(s);
        ObjectMapper mapper = new ObjectMapper();
        RedisUtil.set("session_"+this.session.getId(),username);
        String Json = "";
        try {
            Json = mapper.writeValueAsString(messageVO);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }

        this.sendMessage(Json);
        log.info("【websocket消息】有新的连接, 总数:{}", webSockets.size());
    }


    @OnClose
    public void onClose() {
        String s = RedisUtil.get("session_" + this.session.getId());
        webSockets.remove(this);

        messageVO.setType(2);
        messageVO.setUserNum(webSockets.size());
        messageVO.setMessage("有用户离开");
        messageVO.setUserName(s);

        ObjectMapper mapper = new ObjectMapper();

        String Json = "";
        try {
            Json = mapper.writeValueAsString(messageVO);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }

        this.sendMessage(Json);


        log.info("【websocket消息】连接断开, 总数:{}", webSockets.size());
    }

    @OnMessage
    public void onMessage(String message) {
        String[] split = message.split("_");
        messageVO.setType(3);
        messageVO.setUserNum(webSockets.size());
        messageVO.setMessage(split[0]);
        messageVO.setCreateDate(new Date());
        messageVO.setUserName(split[1]);
        ObjectMapper mapper = new ObjectMapper();

        String Json = "";
        try {
            Json = mapper.writeValueAsString(messageVO);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }

        this.sendMessage(Json);

        log.info("【websocket消息】收到客户端发来的消息:{}", message);
    }

    public void sendMessage(String message) {
        for (WebSocket webSocket : webSockets) {
            log.info("【websocket消息】广播消息, message={}", message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
