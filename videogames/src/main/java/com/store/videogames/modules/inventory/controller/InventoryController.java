package com.store.videogames.modules.inventory.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.store.videogames.modules.inventory.entity.Inventory;
import com.store.videogames.modules.inventory.services.Interface.IInventory;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    private final IInventory service;

    public InventoryController(IInventory service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Inventory> create(@RequestBody Inventory inventory) {
        return ResponseEntity.ok(service.create(inventory));
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventory> update(
            @PathVariable UUID id,
            @RequestBody Inventory inventory) {
        return ResponseEntity.ok(service.update(id, inventory));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Inventory> partialUpdate(
            @PathVariable UUID id,
            @RequestBody Inventory inventory) {
        return ResponseEntity.ok(service.partialUpdate(id, inventory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.ok("Inventory deleted successfully");
    }
}