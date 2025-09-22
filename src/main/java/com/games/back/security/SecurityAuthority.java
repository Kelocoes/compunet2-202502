package com.games.back.security;

import org.springframework.security.core.GrantedAuthority;

import com.games.back.model.Permission;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    private final Permission permission;

    @Override
    public String getAuthority() {
        return permission.getName();
    }

}