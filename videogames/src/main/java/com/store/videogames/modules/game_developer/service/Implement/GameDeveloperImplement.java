package com.store.videogames.modules.game_developer.service.Implement;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.store.videogames.modules.game_developer.entity.GameDeveloper;
import com.store.videogames.modules.game_developer.repository.GameDeveloperRepository;
import com.store.videogames.modules.game_developer.service.Interface.IGameDeveloper;

@Service
public class GameDeveloperImplement implements IGameDeveloper {
    private final GameDeveloperRepository gameDeveloperRepository;

    public GameDeveloperImplement(GameDeveloperRepository gameDeveloperRepository) {
        this.gameDeveloperRepository = gameDeveloperRepository;
    }

    @Override
    public GameDeveloper save(GameDeveloper gameDeveloper) {
        return gameDeveloperRepository.save(gameDeveloper);
    }

    @Override
    public GameDeveloper findById(UUID id) {
        return gameDeveloperRepository.findById(id).orElse(null);
    }

    @Override
    public List<GameDeveloper> findAll() {
        return gameDeveloperRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        gameDeveloperRepository.deleteById(id);
    }
}
