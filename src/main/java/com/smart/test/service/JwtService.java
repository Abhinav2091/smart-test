package com.smart.test.service;

import com.smart.test.model.User;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.function.Function;

public interface JwtService {
    String extractUser(String jwtToken);

    String generateToken(Map<String, Object> claims, UserDetails userDetails);

    boolean isTokenValid(String jwtToken, UserDetails user);

    String generateToken(UserDetails userDetails);

    <T> T extractClaim(String jwtToken, Function<Claims, T> claimsResolver);

    Claims extractAllClaims(String jwtToken);
}
