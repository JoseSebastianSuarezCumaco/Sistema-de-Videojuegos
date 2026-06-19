package com.store.videogames.modules.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.videogames.modules.game.entity.Game;

public interface GameRepository extends JpaRepository<Game, String> {}