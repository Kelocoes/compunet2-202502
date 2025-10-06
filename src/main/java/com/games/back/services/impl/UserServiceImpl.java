package com.games.back.services.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.games.back.dtos.User.UserInDTO;
import com.games.back.dtos.User.UserOutDTO;
import com.games.back.model.User;
import com.games.back.repository.IUserRepository;
import com.games.back.services.IRoleService;
import com.games.back.services.IUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
    private final PasswordEncoder passwordEncoder;
    private final IRoleService roleService;

    @Override
    public List<User> findAll() {
        logger.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        logger.info("Fetching user with ID: " + id);
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public UserOutDTO save(UserInDTO userDto) {
        logger.info("Saving user: " + userDto);
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPasswordHash(passwordEncoder.encode(userDto.getPassword()));
        user.setBirthdate(userDto.getBirthdate());
        user.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        user.setRole(roleService.findById(userDto.getRoleId()));
        User savedUser = userRepository.save(user);
        UserOutDTO outDto = new UserOutDTO();
        outDto.setId(savedUser.getId());
        outDto.setUsername(savedUser.getUsername());
        outDto.setEmail(savedUser.getEmail());
        outDto.setBio(savedUser.getBio());
        outDto.setCreatedAt(savedUser.getCreatedAt());
        outDto.setBirthdate(savedUser.getBirthdate());
        outDto.setRole(savedUser.getRole());
        return outDto;
    }

    @Override
    public void deleteById(Long id) {
        logger.info("Deleting user with ID: " + id);
        userRepository.deleteById(id);
    }
    
    @Override
    public List<User> findAllPage(int page, int size) {
        logger.info("Fetching users for page: " + page + " with size: " + size);
        Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return userRepository.findAll(pageable).toList();
    }

    @Override
    public User findByUsername(String username) {
        logger.info("Fetching user with username: " + username);
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
