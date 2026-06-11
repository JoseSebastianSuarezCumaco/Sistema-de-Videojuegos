package com.store.videogames.modules.genre.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Entity(name="genre")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Genre{
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id_genre")
    private UUID id_genre;

    @Column(name="name", nullable = false, unique = true, length = 50)
    private String name;
}
