package com.store.videogames.modules.genre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.store.videogames.modules.genre.entity.Genre;
import java.util.UUID;

public interface GenreRepository extends JpaRepository<Genre, UUID> {
    // Si se necesita una consulta personalizda, se debe agregar acá
}