package com.store.videogames.modules.sale.entity;

import com.store.videogames.modules.customer.entity.Customer;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "sale")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_sale")
    private String id_sale;

    @Column(name = "sale_date", nullable = false)
    private LocalDateTime sale_date;

    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "id_customer", nullable = false)
    private Customer id_customer;

    @Column(name = "status", length = 20, nullable = false)
    private String status = "pending";

    @Column(name = "payment_method", length = 50)
    private String payment_method;

    @Column(name = "currency", length = 10, nullable = false)
    private String currency = "USD";
}