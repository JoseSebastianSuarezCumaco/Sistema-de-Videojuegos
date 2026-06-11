package com.store.videogames.modules.developer.services.Interface;

import java.util.List;
import java.util.UUID;

import com.store.videogames.modules.developer.entity.Developer;

public interface IDeveloper {

    Developer create(Developer developer);

    List<Developer> getAll();

    Developer getById(UUID id);

    Developer update(UUID id, Developer developer);

    Developer partialUpdate(UUID id, Developer developer);

    boolean delete(UUID id);
}