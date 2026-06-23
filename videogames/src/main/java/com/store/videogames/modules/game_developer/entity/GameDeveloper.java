package com.store.videogames.modules.game_developer.entity;

import java.util.UUID;

import com.store.videogames.modules.developer.entity.Developer;
import com.store.videogames.modules.game.entity.Game;

import jakarta.persistence.Column;
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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "game_developer")
public class GameDeveloper {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_game_developer")
    private UUID id_game_developer;

    @ManyToOne
    @JoinColumn(name = "id_game")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "id_developer")
    private Developer developer;

}
