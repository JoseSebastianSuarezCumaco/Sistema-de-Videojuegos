package com.store.videogames.modules.developer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

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