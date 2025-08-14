package com.example.repository;

import java.util.List;

import com.example.model.User;

public interface IUserRepository {
    User findById(Long id);
    List<User> findAll();
    User save(User user);
    void delete(Long id);
}
