package com.games.back.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.games.back.model.User;
import com.games.back.services.IUserService;

public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userService.findByUsername(username);
            return new CustomUserDetails(user);
        } catch (RuntimeException ex) {
            throw new UsernameNotFoundException("User not found with username: " + username, ex);
        }
    }
}
