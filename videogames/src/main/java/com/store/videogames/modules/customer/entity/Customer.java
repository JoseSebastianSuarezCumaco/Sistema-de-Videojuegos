package com.store.videogames.modules.customer.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.store.videogames.modules.country.entity.Country;

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

@Entity(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_customer")
    private String id_customer;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "profile_name", length = 50)
    private String profile_name;

    @Column(name = "last_name", length = 50)
    private String last_name;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "registration_date")
    private LocalDate registration_date;

    @Column(name = "is_verified")
    private boolean is_verified;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country id_country;

    @Column(name = "deleted_at")
    private LocalDateTime deleted_at;
}