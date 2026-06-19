package com.store.videogames.modules.game.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_game")
    private String id_game;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "base_price", precision = 18, scale = 2)
    private BigDecimal base_price;

    @Column(name = "release_date")
    private LocalDate release_date;

    @Column(name = "description")
    private String description;

    @Column(name = "cover_image_url", length = 255)
    private String cover_image_url;

    @Column(name = "is_active")
    private Boolean is_active;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;
}