package com.example.services;

import java.util.List;

import com.example.model.User;

public interface IUserService {
    User findById(Long id);
    List<User> findAll();
    User save(User user);
    void delete(Long id);
}
