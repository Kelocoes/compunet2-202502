package com.games.back.services;

import java.util.List;

import com.games.back.model.User;
import com.games.back.dtos.User.UserInDTO;
import com.games.back.dtos.User.UserOutDTO;

public interface IUserService {
    
    List<User> findAll();
    User findById(Long id);
    UserOutDTO save(UserInDTO user);
    void deleteById(Long id);
    List<User> findAllPage(int page, int size);
    User findByUsername(String username);
}
