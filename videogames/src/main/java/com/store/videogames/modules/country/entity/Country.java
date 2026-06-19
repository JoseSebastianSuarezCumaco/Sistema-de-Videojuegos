package com.store.videogames.modules.country.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "country")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_country")
    private String id_country;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "code", length = 10, nullable = false)
    private String code;
}