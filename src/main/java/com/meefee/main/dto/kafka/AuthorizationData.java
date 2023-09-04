package com.meefee.main.dto.kafka;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorizationData {

    private int authorizationCode;
    private LocalDateTime authorizationRequestDate;
    private LocalDateTime expiresDate;

}