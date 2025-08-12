package com.example.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Game;
import com.example.repository.IGameRepository;

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
}
