package com.example.ex3_2_back.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
public class MyJwtUtil {
    private final Algorithm algorithm = Algorithm.HMAC256("secret");

    public String createToken(Long uid) {
        return createToken(uid, 60 * 1000);
    }

    private static final String identityKey = "t-username";

    public String createToken(Long userId, int seconds) {
        var calendar = Calendar.getInstance();
        var currentTime = calendar.getTime();
        calendar.add(Calendar.SECOND, seconds);
        var expirationTime = calendar.getTime();

        return JWT.create()
                .withSubject("authentication")
                .withIssuer("issuer")
                .withClaim(identityKey, userId) // 将 userId 添加到 JWT 中
                .withIssuedAt(currentTime)
                .withExpiresAt(expirationTime)
                .sign(algorithm);
    }

    // 解码 Token 并返回用户 ID
    public Optional<Long> decodeToken(String token) {
        try {
            if (token == null || token.isEmpty()) {
                return Optional.empty();
            }
            var verifier = JWT.require(algorithm).build();
            var jwt = verifier.verify(token);
            Long userId = jwt.getClaim(identityKey).asLong();
            return Optional.of(userId);
        } catch (Exception e) {
            log.error(String.format("Error decoding token: %s", e.getMessage()));
            return Optional.empty();
        }
    }

}