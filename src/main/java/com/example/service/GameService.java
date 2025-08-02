package com.example.service;

import com.example.repository.GameRepository;
import java.util.List;

public class GameService {
    
    private GameRepository gameRepository;

    // public GameService(GameRepository gameRepository) {
    //     this.gameRepository = gameRepository;
    // }

    public GameService() {
    }

    public void setGameRepository(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<String> getGames() {
        if (gameRepository == null) {
            throw new IllegalStateException("GameRepository is not initialized");
        }
        return gameRepository.getGames();
    }
}
