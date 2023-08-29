package com.meefee.main.config.ws;

import com.meefee.main.ws.handler.WebSocketConnectHandler;
import com.meefee.main.ws.handler.WebSocketDisconnectHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

@Configuration
@RequiredArgsConstructor
public class WebSocketHandlersConfig<S extends Session> {

    @Bean
    public WebSocketConnectHandler<S> connectHandler(SimpMessageSendingOperations messagingTemplate) {
        WebSocketConnectHandler<S> webSocketConnectHandler = new WebSocketConnectHandler<>(messagingTemplate);
        return webSocketConnectHandler;
    }

    @Bean
    public WebSocketDisconnectHandler<S> disconnectHandler(SimpMessageSendingOperations messagingTemplate) {
        WebSocketDisconnectHandler<S> webSocketDisconnectHandler = new WebSocketDisconnectHandler<>(messagingTemplate);
        return webSocketDisconnectHandler;
    }

}
