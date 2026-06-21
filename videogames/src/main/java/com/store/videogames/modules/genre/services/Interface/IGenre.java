package com.store.videogames.modules.genre.services.Interface;

import java.util.List;
import java.util.UUID;

import com.store.videogames.modules.genre.entity.Genre;

public interface IGenre {
    public Genre create(Genre genre);
    public List<Genre> getAll();
    public Genre getById(UUID genreId);
    public Genre update(UUID genreId, Genre genre);
    public Genre partialUpdate(UUID genreId, Genre genre);
    public boolean delete(UUID genreId);
}
