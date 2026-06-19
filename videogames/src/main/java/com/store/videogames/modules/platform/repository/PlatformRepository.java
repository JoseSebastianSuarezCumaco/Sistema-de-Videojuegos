package com.store.videogames.modules.platform.repository;

import com.store.videogames.modules.platform.entity.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<Platform, String> {}