package com.meefee.main.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class SessionData {

    private Long userId;

    private LocalDateTime lastActivity;

}
