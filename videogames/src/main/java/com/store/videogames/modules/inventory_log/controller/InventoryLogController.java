package com.store.videogames.modules.inventory_log.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.store.videogames.modules.inventory_log.entity.InventoryLog;
import com.store.videogames.modules.inventory_log.services.Interface.IInventoryLog;

@RestController
@RequestMapping("/api/v1/inventory-log")
public class InventoryLogController {

    private final IInventoryLog service;

    public InventoryLogController(IInventoryLog service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<InventoryLog> create(@RequestBody InventoryLog log) {
        return ResponseEntity.ok(service.create(log));
    }

    @GetMapping
    public ResponseEntity<List<InventoryLog>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryLog> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.ok("Log deleted");
    }
}