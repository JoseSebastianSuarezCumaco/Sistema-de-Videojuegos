package com.store.videogames.modules.platform.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.store.videogames.modules.platform.entity.Platform;

public interface PlatformRepository extends JpaRepository<Platform, Integer> {
    // se supone que si necesita una consulta personalizada se debe agregar aqui
}