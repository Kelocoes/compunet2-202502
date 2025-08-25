package com.games.back.services;

import java.util.List;

import com.games.back.model.Game;

public interface IGameService {
    List<Game> removeDefaultGames();
    Game save(Game game);
}
