package com.store.videogames.modules.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.store.videogames.modules.inventory.entity.Inventory;

import java.util.UUID;

public interface InventoryRepository extends JpaRepository<Inventory, UUID> {

}