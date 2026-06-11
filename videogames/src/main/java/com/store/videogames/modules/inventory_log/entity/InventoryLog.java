package com.store.videogames.modules.inventory_log.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

import com.store.videogames.modules.inventory.entity.Inventory;

@Entity(name = "inventory_log")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_log")
    private UUID id_log;

    @ManyToOne
    @JoinColumn(name = "id_inventory", nullable = false)
    private Inventory inventory;

    @Column(name = "movement_type", nullable = false, length = 20)
    private String movement_type; // IN / OUT / ADJUSTMENT

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "reason", length = 255)
    private String reason;

    @Column(name = "log_date")
    private LocalDateTime log_date;

    @PrePersist
    public void prePersist() {
        this.log_date = LocalDateTime.now();
    }
}