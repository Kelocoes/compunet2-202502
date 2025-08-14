package com.example.services;

import java.util.List;

import com.example.model.Game;

public interface IGameService {
    List<Game> findAll();
    Game save(Game game);
}
