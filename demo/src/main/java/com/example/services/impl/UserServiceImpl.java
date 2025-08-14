package com.example.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.IUserRepository;
import com.example.services.IUserService;

public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;

    public UserServiceImpl(@Qualifier("userRepositoryImpl2") IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
    
}
