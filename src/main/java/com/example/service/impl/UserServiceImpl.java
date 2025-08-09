package com.example.service.impl;

import org.springframework.stereotype.Component;

import com.example.model.User;
import com.example.repository.IUserRepository;
import com.example.service.IUserService;

@Component
public class UserServiceImpl implements IUserService{

    private IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
    
}
