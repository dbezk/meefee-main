package com.meefee.main.ws.handler;

import com.meefee.main.redis.OnlineUsersService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;

import java.security.Principal;

@Component
@Slf4j
@Getter
@Setter
public class WebSocketConnectHandler<S> implements ApplicationListener<SessionConnectEvent> {

    private final OnlineUsersService onlineUsersService;

    public WebSocketConnectHandler(SimpMessageSendingOperations messagingTemplate,
                                   OnlineUsersService onlineUsersService) {
        super();
        this.onlineUsersService = onlineUsersService;
    }

    @Override
    public void onApplicationEvent(SessionConnectEvent event) {
        Authentication session = getUser(event);
        onlineUsersService.connectUser((String) session.getPrincipal());
    }

    Authentication getUser(SessionConnectEvent event) {
        MessageHeaders headers = event.getMessage().getHeaders();
        return (Authentication) SimpMessageHeaderAccessor.getUser(headers);
    }

}
