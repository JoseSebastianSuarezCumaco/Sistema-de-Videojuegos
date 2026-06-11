package com.store.videogames.modules.genre.services.Implement;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.videogames.modules.genre.entity.Genre;
import com.store.videogames.modules.genre.repository.GenreRepository;
import com.store.videogames.modules.genre.services.Interface.IGenre;

@Service
public class GenreImplement implements IGenre {

    @Autowired
    private GenreRepository data;

    @Override
    public Genre create(Genre genre) {
        return data.save(genre);
    }

    @Override
    public List<Genre> getAll() {
        return data.findAll();
    }

    @Override
    public Genre getById(UUID genreId) {
        return data.findById(genreId)
                .orElseThrow(() -> new RuntimeException("Genre not found"));
    }

    @Override
    public Genre update(UUID genreId, Genre genre) {
        Genre existing = getById(genreId);

        existing.setName(genre.getName());

        return data.save(existing);
    }

    @Override
    public Genre partialUpdate(UUID genreId, Genre genre) {
        Genre existing = getById(genreId);

        if (genre.getName() != null) {
            existing.setName(genre.getName());
        }

        return data.save(existing);
    }

    @Override
    public boolean delete(UUID genreId) {
        Genre existing = getById(genreId);
        data.delete(existing);
        return true;
    }
}