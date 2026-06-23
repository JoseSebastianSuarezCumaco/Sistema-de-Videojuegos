package com.store.videogames.modules.game_genre.service.Interface;

import java.util.List;
import java.util.UUID;

import com.store.videogames.modules.game_genre.entity.GameGenre;

public interface IGameGenre {
    
    GameGenre save(GameGenre gameGenre);

    List<GameGenre> findAll();

    GameGenre findById(UUID id);

    void deleteById(UUID id);

    List<GameGenre> findByGameId(UUID gameId);

    List<GameGenre> findByGenreId(UUID genreId);
    
}
