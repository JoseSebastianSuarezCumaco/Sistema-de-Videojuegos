package com.store.videogames.modules.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.store.videogames.modules.game.entity.Game;
import com.store.videogames.modules.game.services.Implement.GameImplement;

@RestController
@RequestMapping("/api/v1/game")
public class GameController {

    @Autowired
    GameImplement services;

    @PostMapping("/create")
    public ResponseEntity<Object> Create(@RequestBody Game game) {
        String retorno = services.Create(game);
        return new ResponseEntity<Object>(retorno, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Game>> GetAll() {
        var retorno = services.GetAll();
        return new ResponseEntity<List<Game>>(retorno, HttpStatus.OK);
    }
}