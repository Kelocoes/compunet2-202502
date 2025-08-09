package com.example.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.model.User;
import com.example.repository.IUserRepository;

@Component
public class UserRepositoryImpl implements IUserRepository {

    private List<User> users = new ArrayList<>();
    
    @Override
    public Optional<User> getUserById(Long id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }
}
