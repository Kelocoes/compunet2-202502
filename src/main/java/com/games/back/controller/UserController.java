package com.games.back.controller;

import java.sql.Timestamp;
import java.util.List;

import com.games.back.model.User;
import com.games.back.services.IUserService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/findAllPage")
    public List<User> findAllPage() {
        return userService.findAllPage(0, 2);
    }

    @GetMapping("/findById")
    public User findById() {
        return userService.findById(3L);
    }

    @GetMapping("/save")
    public User save() {
        User newUser = new User();
        newUser.setUsername("Username");
        newUser.setEmail("email@gmail.com");
        newUser.setPassword_hash("123456");
        newUser.setBio("Bio");
        newUser.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return userService.save(newUser);
    }

    @GetMapping("/deleteById")
    public String deleteById() {
        userService.deleteById(2L);
        return "User with ID " + 2L + " deleted successfully.";
    }
}
