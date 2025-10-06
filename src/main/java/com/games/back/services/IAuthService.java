package com.games.back.services;

import com.games.back.dtos.Auth.LoginRequestDTO;
import com.games.back.dtos.Auth.TokenResponseDTO;

public interface IAuthService {
    TokenResponseDTO login(LoginRequestDTO request);
}