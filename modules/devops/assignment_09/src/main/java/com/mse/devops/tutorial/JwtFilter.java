package com.mse.devops.tutorial;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.filter.GenericFilterBean;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JwtFilter extends GenericFilterBean {
    @Value("${jwt.secret}")
    private String secret;

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final String authHeader = request.getHeader("authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new ServletException("Missing or invalid Authorization header");
        }

        final String token = authHeader.substring(7);
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

        try {
            final Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            request.setAttribute("claims", claims);
        } catch (final Exception e) {
            throw new ServletException("Invalid token");
        }
        chain.doFilter(req, res);
    }
}
