package com.store.videogames.modules.genre.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.store.videogames.modules.genre.entity.Genre;
import com.store.videogames.modules.genre.services.Implement.GenreImplement;

@RestController
@RequestMapping("/api/v1/genre")
public class GenreController {

    @Autowired
    private GenreImplement service;

    @PostMapping
    public ResponseEntity<Genre> create(@RequestBody Genre genre) {
        return ResponseEntity.ok(service.create(genre));
    }

    @GetMapping
    public ResponseEntity<List<Genre>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genre> update(@PathVariable UUID id, @RequestBody Genre genre) {
        return ResponseEntity.ok(service.update(id, genre));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Genre> partialUpdate(@PathVariable UUID id, @RequestBody Genre genre) {
        return ResponseEntity.ok(service.partialUpdate(id, genre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}