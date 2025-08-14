package com.example.repository;

import java.util.List;

import com.example.model.Game;

public interface IGameRepository {
    List<Game> findAll();
    Game save(Game game);
    void init();
    void destroy();
}
