package com.store.videogames.modules.inventory_log.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.store.videogames.modules.inventory_log.entity.InventoryLog;

import java.util.UUID;

public interface InventoryLogRepository extends JpaRepository<InventoryLog, UUID> {

}