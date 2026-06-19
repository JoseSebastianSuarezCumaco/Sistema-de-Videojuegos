package com.store.videogames.modules.game.services.Implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.videogames.modules.game.entity.Game;
import com.store.videogames.modules.game.repository.GameRepository;
import com.store.videogames.modules.game.services.Interface.IGame;

@Service
public class GameImplement implements IGame {

    @Autowired
    GameRepository data;

    @Override
    public String Create(Game game) {
        try {
            data.save(game);
            return "Game created successfully";
        } catch (Exception e) {
            return "Error creating game: " + e.getMessage();
        }
    }

    @Override
    public List<Game> GetAll() {
        return data.findAll();
    }

    @Override
    public Game GetById(String gameId) {
        Optional<Game> game = data.findById(gameId);

        if (!game.isPresent()) {
            throw new RuntimeException("Game not found with id: " + gameId);
        }

        return game.get();
    }

    @Override
    public Game Update(String gameId) {
        throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    @Override
    public Game PartialUpdate(String gameId) {
        throw new UnsupportedOperationException("Unimplemented method 'PartialUpdate'");
    }

    @Override
    public boolean Delete(String gameId) {
        throw new UnsupportedOperationException("Unimplemented method 'Delete'");
    }

    @Override
    public boolean LogicalDelete(String gameId) {
        throw new UnsupportedOperationException("Unimplemented method 'LogicalDelete'");
    }
}