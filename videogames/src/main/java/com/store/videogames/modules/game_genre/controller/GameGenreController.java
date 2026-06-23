package com.store.videogames.modules.game_genre.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.store.videogames.modules.game_genre.entity.GameGenre;
import com.store.videogames.modules.game_genre.service.Interface.IGameGenre;

@RestController
@RequestMapping("/game-genres") 
public class GameGenreController {

    private final IGameGenre gameGenreService;

    public GameGenreController(IGameGenre gameGenreService) {
        this.gameGenreService = gameGenreService;
    }

    @PostMapping
    public GameGenre save(@RequestBody GameGenre gameGenre) {
        return gameGenreService.save(gameGenre);
    }

    @GetMapping
    public List<GameGenre> findAll() {
        return gameGenreService.findAll();
    }

    @GetMapping("/{id}")
    public GameGenre findById(@PathVariable UUID id) {
        return gameGenreService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        gameGenreService.deleteById(id);
    }
}