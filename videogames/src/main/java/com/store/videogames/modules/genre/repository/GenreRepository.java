package com.store.videogames.modules.genre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.store.videogames.modules.genre.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    // Si se necesita una consulta personalizda, se debe agregar acá
}