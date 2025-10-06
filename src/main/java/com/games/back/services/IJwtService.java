package com.games.back.services;

import java.util.List;
import java.util.function.Function;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.games.back.model.User;

import io.jsonwebtoken.Claims;

public interface IJwtService {
    String generateToken(User user, Authentication authentication);
    String extractUsername(String token);
    List<SimpleGrantedAuthority> extractAuthorities(String token);
    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);
    UserDetails getUserDetailsFromToken(String token);
    boolean isTokenExpired(String token);
    boolean isTokenValid(String token);
}
