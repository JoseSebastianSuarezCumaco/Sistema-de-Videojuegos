package com.store.videogames.modules.game_genre.service.Implement;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.store.videogames.modules.game_genre.entity.GameGenre;
import com.store.videogames.modules.game_genre.repository.GameGenreRepository;
import com.store.videogames.modules.game_genre.service.Interface.IGameGenre;

@Service
public class GameGenreImplement implements IGameGenre {

    private final GameGenreRepository repository;

    public GameGenreImplement(GameGenreRepository repository) {
        this.repository = repository;
    }

    @Override
    public GameGenre save(GameGenre gameGenre) {
        return repository.save(gameGenre);
    }

    @Override
    public List<GameGenre> findAll() {
        return repository.findAll();
    }

    @Override
    public GameGenre findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("GameGenre not found"));
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<GameGenre> findByGameId(UUID gameId) {
        return repository.findByGameId(gameId);
    }

    @Override
    public List<GameGenre> findByGenreId(UUID genreId) {
        return repository.findByGenreId(genreId);
    }
}