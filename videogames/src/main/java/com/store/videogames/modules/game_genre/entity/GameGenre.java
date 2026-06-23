package com.store.videogames.modules.game_genre.entity;

import java.util.UUID;

import com.store.videogames.modules.game.entity.Game;
import com.store.videogames.modules.genre.entity.Genre;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "game_genre")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_game")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "id_genre")
    private Genre genre;
}
