package com.example.repository;

import java.util.Optional;

import com.example.model.User;

public interface IUserRepository {
    Optional<User> getUserById(Long id);
    User save(User user);
}
