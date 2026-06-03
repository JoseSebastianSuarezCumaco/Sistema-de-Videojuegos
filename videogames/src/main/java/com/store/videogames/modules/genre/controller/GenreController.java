package com.store.videogames.modules.genre.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.store.videogames.modules.genre.entity.Genre;
import com.store.videogames.modules.genre.services.Implement.GenreImplement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



// @Controller
@RestController
@RequestMapping("/api/v1/genre")
public class GenreController {
    @Autowired
    GenreImplement service;

    @PostMapping("/create")
    public ResponseEntity<Object> Create(@RequestBody Genre genre) {
        String retorno=service.Create(genre);
        // if(retorno.startsWith("Error creating genre")){
        //     String message = "Error";
        // } else {
        //     String message = "Creado exitosamente";
        // }
        
        return new ResponseEntity<Object>(retorno,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Genre>> GetAll() {
        var retorno=service.GetAll();
        return new ResponseEntity<List<Genre>>(retorno,HttpStatus.OK);
    }
    
    
}
