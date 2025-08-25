package com.games.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.games.back.model.Game;

@Repository
public interface IGameRepository extends JpaRepository<Game, Long> {
    
}
