package com.example.service;

import com.example.model.User;

public interface IUserService {

    User getUserById(Long id);
    User save(User user);
    void init();
    void destroy();
} 
