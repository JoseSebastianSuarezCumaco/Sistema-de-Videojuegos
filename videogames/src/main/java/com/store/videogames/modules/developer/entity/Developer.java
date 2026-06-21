package com.store.videogames.modules.developer.entity;

import java.util.UUID;

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

@Entity(name = "developer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_developer")
    private UUID id_developer;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_country", nullable = false)
    private Country country;

    @Column(name = "website_url", length = 255)
    private String website_url;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "logo_url", length = 255)
    private String logo_url;
}