package com.games.back.services.impl;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.query.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.games.back.model.User;
import com.games.back.repository.IUserRepository;
import com.games.back.services.IUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository usserRepository;
    private final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

    @Override
    public List<User> findAll() {
        logger.info("Fetching all users");
        return usserRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        logger.info("Fetching user with ID: " + id);
        return usserRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User save(User user) {
        logger.info("Saving user: " + user);
        return usserRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        logger.info("Deleting user with ID: " + id);
        usserRepository.deleteById(id);
    }
    
    @Override
    public List<User> findAllPage(int page, int size) {
        logger.info("Fetching users for page: " + page + " with size: " + size);
        Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return usserRepository.findAll(pageable).toList();
    }
}
