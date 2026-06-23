package com.store.videogames.modules.game_developer.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.videogames.modules.game_developer.entity.GameDeveloper;

public interface  GameDeveloperRepository extends JpaRepository<GameDeveloper, UUID> {
    
}
