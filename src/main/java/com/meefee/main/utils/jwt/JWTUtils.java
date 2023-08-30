package com.meefee.main.utils.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collection;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JWTUtils {

    @Value(value = "${jwt.secret}")
    private String jwtSecret;

    public Algorithm getJwtAlgorithm() {
        return Algorithm.HMAC256(jwtSecret);
    }

    public JWTVerifier getJWTVerifier(Algorithm algorithm) {
        return JWT.require(algorithm).build();
    }

    public String generateAccessToken(String subject, String issuerURL, Collection<GrantedAuthority> authorityCollection) {
        return JWT.create()
                .withSubject(subject)
                .withIssuer(issuerURL)
                .withClaim("roles", authorityCollection.stream().map(GrantedAuthority::getAuthority).toList())
//                .withExpiresAt(Date.from(LocalDateTime.now().plusDays(5).toInstant(ZoneOffset.UTC)))
                .withExpiresAt(new Date(System.currentTimeMillis() + 12 * 60 * 60 * 1000))
                .sign(getJwtAlgorithm());
    }

}
