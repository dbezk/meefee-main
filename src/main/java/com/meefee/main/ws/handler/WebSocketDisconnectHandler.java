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
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@Slf4j
@Getter
@Setter
public class WebSocketDisconnectHandler<S> implements ApplicationListener<SessionDisconnectEvent> {

    private final OnlineUsersService onlineUsersService;

    public WebSocketDisconnectHandler(SimpMessageSendingOperations messagingTemplate,
                                      OnlineUsersService onlineUsersService) {
        super();
        this.onlineUsersService = onlineUsersService;
    }

    @Override
    public void onApplicationEvent(SessionDisconnectEvent event) {
        Authentication session = getUser(event);
        onlineUsersService.disconnectUser((String) session.getPrincipal());
    }

    Authentication getUser(SessionDisconnectEvent event) {
        MessageHeaders header = event.getMessage().getHeaders();
        return (Authentication) SimpMessageHeaderAccessor.getUser(header);
    }
}
