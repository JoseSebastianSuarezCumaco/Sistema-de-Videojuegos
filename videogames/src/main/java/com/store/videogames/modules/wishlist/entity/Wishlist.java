package com.store.videogames.modules.wishlist.entity;

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

@Entity(name = "wishlist")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_wishlist")
    private String id_wishlist;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer id_customer;

    @ManyToOne
    @JoinColumn(name = "id_game")
    private Game id_game;

    @Column(name = "added_at")
    private LocalDateTime added_at;
}