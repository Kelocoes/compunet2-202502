package com.games.back.services.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.games.back.dtos.User.UserInDTO;
import com.games.back.dtos.User.UserOutDTO;
import com.games.back.mappers.IUserMapper;
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
    private final IUserMapper userMapper;

    @Override
    public List<UserOutDTO> findAll() {
        logger.info("Fetching all users");
        List<User> users = userRepository.findAll();
        List<UserOutDTO> userDtos = users.stream()
                .map(userMapper::userToUserOutDto)
                .toList();
        return userDtos;
    }

    @Override
    public UserOutDTO findById(Long id) {
        logger.info("Fetching user with ID: " + id);
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.userToUserOutDto(user);
    }

    @Override
    public UserOutDTO save(UserInDTO userDto) {
        logger.info("Saving user: " + userDto);
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User user = userMapper.userInDtoToUser(userDto);
        user.setRole(roleService.findById(userDto.getRoleId()));
        User savedUser = userRepository.save(user);
        UserOutDTO outDto = userMapper.userToUserOutDto(savedUser);
        return outDto;
    }

    @Override
    public void deleteById(Long id) {
        logger.info("Deleting user with ID: " + id);
        userRepository.deleteById(id);
    }
    
    @Override
    public List<UserOutDTO> findAllPage(int page, int size) {
        logger.info("Fetching users for page: " + page + " with size: " + size);
        Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return userRepository.findAll(pageable).stream()
                .map(userMapper::userToUserOutDto)
                .toList();
    }

    @Override
    public UserOutDTO findByUsername(String username) {
        logger.info("Fetching user with username: " + username);
        return userRepository.findByUsername(username)
            .map(userMapper::userToUserOutDto)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
