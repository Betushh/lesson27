package com.mydemo.mydemo.jwt.jwtImpl;

import com.mydemo.mydemo.Models.security.Authority;
import com.mydemo.mydemo.Models.security.User;
import com.mydemo.mydemo.jwt.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class JwtServiceImpl implements JwtService {

    @Value("${issue.key}")
    private String issueKey;


    @PostConstruct
    public Key secrectKey() {
        byte[] keyBytes = Decoders.BASE64.decode(issueKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public String issueToken(User user) {

        List<String> authorities = user
                .getAuthorities()
                .stream()
                .map(Authority::getAuthority)
                .toList();

        final JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(Instant.now().plus(Duration.ofSeconds(6000))))
                .addClaims(Map.of("roles", authorities))
                .setHeader(Map.of("type", "JWT"))
                .signWith(secrectKey(), SignatureAlgorithm.HS256);

        return jwtBuilder.compact();
    }

    @Override
    public Claims verifyToken(String token) {
        return Jwts.parser()// Builer yazanmadim
                .setSigningKey(secrectKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
