package com.store.videogames.modules.game_developer.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.videogames.modules.game_developer.entity.GameDeveloper;
import com.store.videogames.modules.game_developer.service.Interface.IGameDeveloper;

@RestController
@RequestMapping("/game-developers")
public class GameDeveloperController {
    private final IGameDeveloper gameDeveloperService;

    public GameDeveloperController(IGameDeveloper gameDeveloperService) {
        this.gameDeveloperService = gameDeveloperService;
    }

    @PostMapping
    public GameDeveloper save(@RequestBody GameDeveloper gameDeveloper) {
        return gameDeveloperService.save(gameDeveloper);
    }

    @GetMapping
    public List<GameDeveloper> findAll() {
        return gameDeveloperService.findAll();
    }

    @GetMapping("/{id}")
    public GameDeveloper findById(@PathVariable UUID id) {
        return gameDeveloperService.findById(id);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        gameDeveloperService.deleteById(id);
    }
}

