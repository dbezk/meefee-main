package com.meefee.main.ws.handler;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@Slf4j
@Getter
@Setter
public class WebSocketDisconnectHandler<S> implements ApplicationListener<SessionDisconnectEvent> {

    public WebSocketDisconnectHandler(SimpMessageSendingOperations messagingTemplate) {
        super();
    }

    @Override
    public void onApplicationEvent(SessionDisconnectEvent event) {
        log.info("Connected new session = {}", event.getUser().getName());
    }
}
