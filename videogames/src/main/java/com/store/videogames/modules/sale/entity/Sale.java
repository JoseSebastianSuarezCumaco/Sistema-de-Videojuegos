package com.store.videogames.modules.sale.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.store.videogames.modules.customer.entity.Customer;

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

@Entity(name = "sale")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_sale")
    private String id_sale;

    @Column(name = "sale_date")
    private LocalDateTime sale_date;

    @Column(name = "total", precision = 18, scale = 2)
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer id_customer;

    @Column(name = "status", length = 30)
    private String status;

    @Column(name = "payment_method", length = 54)
    private String payment_method;

    @Column(name = "currency", length = 30)
    private String currency;
}