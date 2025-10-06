package com.games.back.services.impl;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.games.back.dtos.Auth.LoginRequestDTO;
import com.games.back.dtos.Auth.TokenResponseDTO;
import com.games.back.model.User;
import com.games.back.security.CustomUserDetails;
import com.games.back.security.CustomUserDetailsService;
import com.games.back.services.IAuthService;
import com.games.back.services.IJwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final IJwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public TokenResponseDTO login(LoginRequestDTO request) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        if (userDetails == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        if (!passwordEncoder.matches(request.getPassword(), userDetails.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }
        CustomUserDetails customUD = (CustomUserDetails) userDetails;
        User user = customUD.getUser();
        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
        String token = jwtService.generateToken(user, auth);
        return new TokenResponseDTO(token); 
    }
    
}
