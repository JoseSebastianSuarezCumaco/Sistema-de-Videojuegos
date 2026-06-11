package com.store.videogames.modules.inventory.services.Implement;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.store.videogames.modules.inventory.entity.Inventory;
import com.store.videogames.modules.inventory.repository.InventoryRepository;
import com.store.videogames.modules.inventory.services.Interface.IInventory;

@Service
public class InventoryImplement implements IInventory {

    private final InventoryRepository repository;

    public InventoryImplement(InventoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Inventory create(Inventory inventory) {
        return repository.save(inventory);
    }

    @Override
    public List<Inventory> getAll() {
        return repository.findAll();
    }

    @Override
    public Inventory getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));
    }

    @Override
    public Inventory update(UUID id, Inventory inventory) {
        Inventory existing = getById(id);

        existing.setGame(inventory.getGame());
        existing.setPlatform(inventory.getPlatform());
        existing.setStock(inventory.getStock());

        return repository.save(existing);
    }

    @Override
    public Inventory partialUpdate(UUID id, Inventory inventory) {
        Inventory existing = getById(id);

        if (inventory.getGame() != null) {
            existing.setGame(inventory.getGame());
        }
        if (inventory.getPlatform() != null) {
            existing.setPlatform(inventory.getPlatform());
        }
        if (inventory.getStock() != null) {
            existing.setStock(inventory.getStock());
        }

        return repository.save(existing);
    }

    @Override
    public boolean delete(UUID id) {
        Inventory existing = getById(id);
        repository.delete(existing);
        return true;
    }
}