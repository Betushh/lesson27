package com.mydemo.mydemo.jwt;

import com.mydemo.mydemo.Models.security.User;
import io.jsonwebtoken.Claims;

public interface JwtService {

    String issueToken(User user);

    Claims verifyToken(String token);
}
