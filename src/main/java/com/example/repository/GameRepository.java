package com.example.repository;

import java.util.List;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;

public class GameRepository {
    
    private List<String> games;
    private Logger logger = Logger.getLogger(GameRepository.class.getName());

    public void init() {
        logger.info("GameRepository initialized");
        logger.info("Connecting to the game database...");

        this.games = Arrays.asList(
            "Poker",
            "Chess",
            "Monopoly"
        );
    }

    public GameRepository() {
    }

    public List<String> getGames() {
        return this.games;
    }

    public void destroy() {
        logger.info("GameRepository destroyed");
        logger.info("Disconnecting from the game database...");
    }
}
