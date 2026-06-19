package com.store.videogames.modules.game.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "game")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_game")
    private String id_game;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "base_price", precision = 10, scale = 2)
    private java.math.BigDecimal base_price;

    @Column(name = "is_active")
    private boolean is_active = true;
}