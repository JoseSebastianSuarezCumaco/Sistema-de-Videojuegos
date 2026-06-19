package com.store.videogames.modules.library.entity;

import java.time.LocalDateTime;

import com.store.videogames.modules.customer.entity.Customer;
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

@Entity(name = "library")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_library")
    private String id_library;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer id_customer;

    @ManyToOne
    @JoinColumn(name = "id_game")
    private Game id_game;

    @Column(name = "acquired_at")
    private LocalDateTime acquired_at;
}