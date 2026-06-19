package com.store.videogames.modules.sale_detail.entity;

import java.math.BigDecimal;

import com.store.videogames.modules.game.entity.Game;
import com.store.videogames.modules.sale.entity.Sale;

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

@Entity(name = "sale_detail")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class SaleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_detail")
    private String id_detail;

    @ManyToOne
    @JoinColumn(name = "id_sale", nullable = false)
    private Sale id_sale;

    @ManyToOne
    @JoinColumn(name = "id_game", nullable = false)
    private Game id_game;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal unit_price;

    @Column(name = "discount_applied", precision = 10, scale = 2)
    private BigDecimal discount_applied = BigDecimal.ZERO;
}