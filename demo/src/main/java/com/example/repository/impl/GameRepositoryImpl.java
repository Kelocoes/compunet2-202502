package com.example.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.model.Game;
import com.example.repository.IGameRepository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/*
 * 
 * DAO: Data access object
 */
public class GameRepositoryImpl implements IGameRepository{
    
    private List<Game> games = new ArrayList<>();

    @Override
    public List<Game> findAll() {
        return games;
    }

    @Override
    public Game save(Game game) {
        games.add(game);
        return game;
    }

    @Override
    public void init() {
        System.out.println("Initializing GameRepositoryImpl");
    }

    @Override
    public void destroy() {
        System.out.println("Destroying GameRepositoryImpl");
    }
}
