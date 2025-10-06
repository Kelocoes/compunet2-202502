package com.games.back.services;

import java.util.List;

import com.games.back.dtos.User.UserInDTO;
import com.games.back.dtos.User.UserOutDTO;

public interface IUserService {
    
    List<UserOutDTO> findAll();
    UserOutDTO findById(Long id);
    UserOutDTO save(UserInDTO user);
    void deleteById(Long id);
    List<UserOutDTO> findAllPage(int page, int size);
    UserOutDTO findByUsername(String username);
}
