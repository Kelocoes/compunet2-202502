package com.example.repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class GameRepository {
    
    private List<String> games;

    public GameRepository() {
        this.games = Arrays.asList(
            "Poker",
            "Chess",
            "Monopoly"
        );
    }

    public List<String> getGames() {
        return this.games;
    }
}
