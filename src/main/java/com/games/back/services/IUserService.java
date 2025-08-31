package com.games.back.services;

import java.util.List;

import com.games.back.model.User;

public interface IUserService {
    
    List<User> findAll();
    User findById(Long id);
    User save(User user);
    void deleteById(Long id);
    List<User> findAllPage(int page, int size);
}
