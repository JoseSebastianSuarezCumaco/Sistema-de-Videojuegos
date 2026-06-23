package com.store.videogames.modules.game_developer.service.Interface;

import java.util.List;
import java.util.UUID;

import com.store.videogames.modules.game_developer.entity.GameDeveloper;

public interface IGameDeveloper {
    GameDeveloper save(GameDeveloper gameDeveloper);
    List<GameDeveloper> findAll();
    GameDeveloper findById(UUID id);
    void deleteById(UUID id);
}
