package com.example.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.model.User;
import com.example.repository.IUserRepository;

public class UserRepositoryImpl implements IUserRepository{

    private List<User> users = new ArrayList<>();

    @Override
    public User findById(Long id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
