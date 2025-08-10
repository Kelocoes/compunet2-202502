package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.repository.IUserRepository;
import com.example.repository.impl.UserRepositoryImpl;
import com.example.service.IUserService;
import com.example.service.impl.UserServiceImpl;

@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {
    

    // @Bean(name = "userRepository")
    // @Scope("singleton")
    // public IUserRepository userRepository() {
    //     return new UserRepositoryImpl();
    // }

    // @Bean(name = "userServiceImpl", initMethod = "init", destroyMethod = "destroy")
    // public IUserService userService() {
    //     return new UserServiceImpl(userRepository());
    // }
}
