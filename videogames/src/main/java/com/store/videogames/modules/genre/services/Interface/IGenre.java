package com.store.videogames.modules.genre.services.Interface;

import java.util.List;

import org.springframework.scheduling.config.Task;

import com.store.videogames.modules.genre.entity.Genre;

public interface IGenre {
    /*
     Definir los métodos que se van a usar

     -Create
     -Get
     -GetById
     -Update
     -PartialUpdate
     -Delete
     -LogicalDelete
    */

    public String Create(Genre genre);
    public List<Genre> GetAll();
    public Genre GetById(Integer genreId);
    public Genre Update(Integer genreId);
    public Genre PartialUpdate(Integer genreId);
    public boolean Delete(Integer genreId);
    public boolean LogicalDelete(Integer genreId);
}
