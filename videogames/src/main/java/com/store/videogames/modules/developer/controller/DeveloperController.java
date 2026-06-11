package com.store.videogames.modules.developer.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.store.videogames.modules.developer.entity.Developer;
import com.store.videogames.modules.developer.services.Interface.IDeveloper;

@RestController
@RequestMapping("/api/v1/developer")
public class DeveloperController {

    private final IDeveloper service;

    public DeveloperController(IDeveloper service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Developer> create(@RequestBody Developer developer) {
        return ResponseEntity.ok(service.create(developer));
    }

    @GetMapping
    public ResponseEntity<List<Developer>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Developer> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Developer> update(
            @PathVariable UUID id,
            @RequestBody Developer developer) {
        return ResponseEntity.ok(service.update(id, developer));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Developer> partialUpdate(
            @PathVariable UUID id,
            @RequestBody Developer developer) {
        return ResponseEntity.ok(service.partialUpdate(id, developer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.ok("Developer deleted successfully");
    }
}