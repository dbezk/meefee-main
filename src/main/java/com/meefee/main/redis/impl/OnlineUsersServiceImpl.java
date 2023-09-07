package com.meefee.main.redis.impl;

import com.meefee.main.data.SessionData;
import com.meefee.main.redis.OnlineUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OnlineUsersServiceImpl implements OnlineUsersService {

    private final RedisTemplate<String, SessionData> redisTemplate;

    @Override
    public void connectUser(String sessionId) {
        redisTemplate.opsForValue().set(sessionId, new SessionData(null, LocalDateTime.now()));
    }

    @Override
    public void disconnectUser(String sessionId) {
        redisTemplate.opsForValue().getAndDelete(sessionId);
    }

}
