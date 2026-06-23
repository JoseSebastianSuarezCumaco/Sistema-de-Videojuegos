package com.store.videogames.modules.game_genre.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.videogames.modules.game_genre.entity.GameGenre;


@Repository
public interface GameGenreRepository extends JpaRepository<GameGenre, UUID> {
    List<GameGenre> findByGameId(UUID gameId);

    List<GameGenre> findByGenreId(UUID genreId);
}
