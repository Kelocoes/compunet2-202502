package com.games.back.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.games.back.model.Game;
import com.games.back.repository.IGameRepository;
import com.games.back.services.IGameService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements IGameService {
    
    private final IGameRepository gameRepository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public List<Game> removeDefaultGames() {
        System.out.println("Deleting default games...");


        List<Game> existingGames = gameRepository.findAll();

        // Guardar los juegos en la base de datos
        existingGames.forEach(game -> {
            gameRepository.deleteById(game.getId());
            System.out.println("Deleted game: " + game.getName());

            // Simular un error para forzar un rollback
            if ("Pandemic".equals(game.getName())) {
                throw new RuntimeException("Error al guardar el juego Monopoly. Se hará rollback.");
            }
        });

        return existingGames;
    }

    @Override
    public Game save(Game game) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}
