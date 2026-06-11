package com.store.videogames.modules.inventory_log.services.Implement;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.store.videogames.modules.inventory.entity.Inventory;
import com.store.videogames.modules.inventory.repository.InventoryRepository;
import com.store.videogames.modules.inventory_log.entity.InventoryLog;
import com.store.videogames.modules.inventory_log.repository.InventoryLogRepository;
import com.store.videogames.modules.inventory_log.services.Interface.IInventoryLog;

@Service
public class InventoryLogImplement implements IInventoryLog {

    private final InventoryLogRepository logRepository;
    private final InventoryRepository inventoryRepository;

    public InventoryLogImplement(
            InventoryLogRepository logRepository,
            InventoryRepository inventoryRepository) {
        this.logRepository = logRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public InventoryLog create(InventoryLog log) {

        Inventory inventory = inventoryRepository.findById(
                log.getInventory().getId_inventory())
                .orElseThrow(() -> new RuntimeException("Inventory not found"));

        // 🔥 LÓGICA DE NEGOCIO
        switch (log.getMovement_type().toUpperCase()) {
            case "IN":
                inventory.setStock(inventory.getStock() + log.getQuantity());
                break;

            case "OUT":
                if (inventory.getStock() < log.getQuantity()) {
                    throw new RuntimeException("Not enough stock");
                }
                inventory.setStock(inventory.getStock() - log.getQuantity());
                break;

            case "ADJUSTMENT":
                inventory.setStock(log.getQuantity());
                break;

            default:
                throw new RuntimeException("Invalid movement type");
        }

        inventoryRepository.save(inventory);

        return logRepository.save(log);
    }

    @Override
    public List<InventoryLog> getAll() {
        return logRepository.findAll();
    }

    @Override
    public InventoryLog getById(UUID id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Log not found"));
    }

    @Override
    public boolean delete(UUID id) {
        InventoryLog log = getById(id);
        logRepository.delete(log);
        return true;
    }
}