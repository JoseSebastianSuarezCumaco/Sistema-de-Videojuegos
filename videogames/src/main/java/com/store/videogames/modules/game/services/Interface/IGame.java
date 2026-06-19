package com.store.videogames.modules.game.services.Interface;

import java.util.List;

import com.store.videogames.modules.game.entity.Game;

public interface IGame {

    public String Create(Game game);

    public List<Game> GetAll();

    public Game GetById(String gameId);

    public Game Update(String gameId);

    public Game PartialUpdate(String gameId);

    public boolean Delete(String gameId);

    public boolean LogicalDelete(String gameId);
}