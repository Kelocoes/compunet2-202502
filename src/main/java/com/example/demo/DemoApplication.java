package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private IUserService userService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @PostConstruct
    public void init() {
        System.out.println("Inicie!");
        
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initReal() {
        List<User> users = userService.findAll();

        for (User user : users) {
            System.out.println(user);
        };
    }

}
