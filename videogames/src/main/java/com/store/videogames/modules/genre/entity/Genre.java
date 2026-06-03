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

@Entity(name="genre")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Genre{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_genre")
    private int id_genre;

    @Column(name="name",length = 150)
    private String name;

    @Column(name="status")
    private boolean status;
}
