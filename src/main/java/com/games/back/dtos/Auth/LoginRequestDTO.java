package com.games.back.dtos.Auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {
    
    private String username;
    private String password;
}
