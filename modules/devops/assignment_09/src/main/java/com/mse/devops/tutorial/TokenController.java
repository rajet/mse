package com.mse.devops.tutorial;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;

@RestController
public class TokenController {
    @Value("${jwt.secret}")
    private String secret;

    @PostMapping(value = "/token", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
        System.out.println(secret);
        String jwt = Jwts.builder()
                .setSubject(username)
                .claim("roles", "guest")
                .setIssuedAt(new Date())
                .setExpiration(Date.from(Instant.now().plusSeconds(3600)))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return ResponseEntity.ok(jwt);
    }
}
