package com.store.videogames.modules.developer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.store.videogames.modules.developer.entity.Developer;

import java.util.UUID;

public interface DeveloperRepository extends JpaRepository<Developer, UUID> {

    // Ejemplo opcional:
    // boolean existsByName(String name);

}