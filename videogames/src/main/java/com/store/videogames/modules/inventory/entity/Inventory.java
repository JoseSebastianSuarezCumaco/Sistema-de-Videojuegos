package com.store.videogames.modules.inventory.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

import com.store.videogames.modules.game.entity.Game;
import com.store.videogames.modules.platform.entity.Platform;

@Entity(name = "inventory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_inventory")
    private UUID id_inventory;

    @ManyToOne
    @JoinColumn(name = "id_game", nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "id_platform", nullable = false)
    private Platform platform;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;
}