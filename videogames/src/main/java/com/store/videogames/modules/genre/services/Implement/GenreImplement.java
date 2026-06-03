package com.store.videogames.modules.genre.services.Implement;

import java.util.List;
import java.util.Optional;

import org.hibernate.sql.ast.tree.expression.Over;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.videogames.modules.genre.entity.Genre;
import com.store.videogames.modules.genre.repository.GenreRepository;
import com.store.videogames.modules.genre.services.Interface.IGenre;

@Service
public class GenreImplement implements IGenre{
    @Autowired
    GenreRepository data;
    
    @Override
    public String Create(Genre genre){
       try {
            data.save(genre);
            return "Genre created successfully";
        } catch (Exception e) {
            return "Error creating genre: " + e.getMessage();
        }
    }

     @Override
    public List<Genre> GetAll() {
        return data.findAll();
    }

    @Override
    public Genre GetById(Integer genreId) {
        Optional<Genre> genre = data.findById(genreId);
        if (!genre.isPresent()) {
            throw new RuntimeException("Genre not found with id: " + genreId);
        }
        return genre.get();
    }

    @Override
    public Genre Update(Integer genreId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    @Override
    public Genre PartialUpdate(Integer genreId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'PartialUpdate'");
    }

    @Override
    public boolean Delete(Integer genreId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Delete'");
    }

    @Override
    public boolean LogicalDelete(Integer genreId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'LogicalDelete'");
    }

}

