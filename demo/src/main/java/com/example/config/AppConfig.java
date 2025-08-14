package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.repository.IGameRepository;
import com.example.repository.IUserRepository;
import com.example.repository.impl.GameRepositoryImpl;
import com.example.repository.impl.UserRepositoryImpl;
import com.example.services.IGameService;
import com.example.services.IUserService;
import com.example.services.impl.GameServiceImpl;
import com.example.services.impl.UserServiceImpl;

@Configuration
public class AppConfig {

    @Bean(name = "userRepository")
    public IUserRepository userRepository() {
        return new UserRepositoryImpl();
    }

    @Bean(name = "userServiceImpl")
    public IUserService userService() {
        return new UserServiceImpl(userRepository());
    }

    @Bean(name = "gameRepository", initMethod = "init", destroyMethod = "destroy")
    public IGameRepository gameRepository() {
        return new GameRepositoryImpl();
    }

    @Bean(name = "gameServiceImpl")
    @Scope("prototype")
    public IGameService gameService() {
        return new GameServiceImpl(gameRepository());
    }
}
