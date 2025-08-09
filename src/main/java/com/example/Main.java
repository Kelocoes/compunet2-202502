package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.model.User;
import com.example.service.IUserService;

import jakarta.annotation.PostConstruct;

@Configuration
@ComponentScan(basePackages = "com.example")
public class Main {

    @Autowired
    IUserService userService;
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
    }

    @PostConstruct
    public void init() {

        User initUser = new User(1L, "kelocoes", "kevin.rodriguez109@gmail.com", "Mi biografía");

        User savedUser = userService.save(initUser);

        System.out.println("Usuario guardado: " + savedUser);
    }
}