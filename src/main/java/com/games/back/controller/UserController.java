package com.games.back.controller;

import java.sql.Timestamp;
import java.util.List;

import com.games.back.dto.UserInDto;
import com.games.back.dto.UserOutDto;
import com.games.back.mappers.IUserMapper;
import com.games.back.mappers.IUserMapperImpl;
import com.games.back.model.User;
import com.games.back.services.IUserService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;
    private final IUserMapper userMapper;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/page")
    public List<User> findAllPage(@RequestParam int page, @RequestParam int size) {
        return userService.findAllPage(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try { 
            User userFound = userService.findById(id);
            UserOutDto userDto = userMapper.userEntityToDto(userFound);
            return ResponseEntity.ok().body(userDto);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public UserOutDto save(@RequestBody UserInDto user) {
        User userEntity = userMapper.userDtoToEntity(user);
        User userSaved = userService.save(userEntity);
        return userMapper.userEntityToDto(userSaved);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return "User with ID " + id + " deleted successfully.";
    }
}
