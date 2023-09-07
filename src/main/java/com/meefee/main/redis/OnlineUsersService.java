package com.meefee.main.redis;

public interface OnlineUsersService {

    void connectUser(String sessionId);
    void disconnectUser(String sessionId);

}
