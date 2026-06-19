package com.store.videogames.modules.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.store.videogames.modules.library.entity.Library;
import com.store.videogames.modules.library.services.Implement.LibraryImplement;

@RestController
@RequestMapping("/api/v1/library")
public class LibraryController {

    @Autowired
    LibraryImplement service;

    @PostMapping("/create")
    public ResponseEntity<Object> Create(@RequestBody Library library) {
        String retorno = service.Create(library);
        return new ResponseEntity<Object>(retorno, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Library>> GetAll() {
        var retorno = service.GetAll();
        return new ResponseEntity<List<Library>>(retorno, HttpStatus.OK);
    }
}