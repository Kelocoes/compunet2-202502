package com.example.services.impl;

import java.util.List;

import com.example.model.Game;
import com.example.repository.IGameRepository;
import com.example.services.IGameService;

public class GameServiceImpl implements IGameService {
    private IGameRepository gameRepository;

    public GameServiceImpl(IGameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public Game save(Game game) {
        return gameRepository.save(game);
    }
    
}
