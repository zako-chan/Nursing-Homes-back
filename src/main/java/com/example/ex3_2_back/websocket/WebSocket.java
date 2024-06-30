package com.example.ex3_2_back.websocket;


import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
@ServerEndpoint("/websocket/{username}")
public class WebSocket {

    private static int onlineCount = 0;
    private static Map<String,WebSocket> clients = new ConcurrentHashMap<String,WebSocket>();
    private Session session;
    private String username;

    @OnOpen
    public void onOpen(@PathParam("username")String username, Session session) {
        this.username = username;
        this.session = session;
        if(clients.containsKey(username)) {
            try{
                clients.get(username).session.close();
                WebSocket.onlineCount--;
                log.info("旧链接关闭："+username);
            }catch (Exception e) {
                log.error("关闭旧的连接时发生错误: " + username, e);
            }
        }
        WebSocket.onlineCount++;
        clients.put(username,this);
        log.info("用户连接:"+username);
    }

    @OnClose
    public void onClose() {
        clients.remove(username);
        WebSocket.onlineCount--;
        log.info("用户退出:"+username);
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("收到消息:"+message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }

    public static void sendMessage(String message, String username) {
        WebSocket webSocket = clients.get(username);
        if (webSocket != null) {
            webSocket.session.getAsyncRemote().sendText(message);
        }
    }

    public static void sendMessage(String message) {
        clients.forEach((key, value) -> value.session.getAsyncRemote().sendText(message));
    }
}
