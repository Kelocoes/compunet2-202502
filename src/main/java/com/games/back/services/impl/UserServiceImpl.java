package com.games.back.services.impl;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.games.back.dto.UserInDto;
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
    public User save(User user) {
        logger.info("Saving user: " + user);
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        user.setRole(roleService.findById(user.getRole(). getId()));
        // userEntity.setEmail(user.getEmail());
        // userEntity.setBirthdate(user.getBirthDate());
        // userEntity.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        // userEntity.setRole(roleService.findById(user.getRoleId()));
        return userRepository.save(user);
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
