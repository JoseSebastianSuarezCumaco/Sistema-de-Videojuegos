package com.store.videogames.modules.inventory_log.services.Interface;

import java.util.List;
import java.util.UUID;

import com.store.videogames.modules.inventory_log.entity.InventoryLog;

public interface IInventoryLog {

    InventoryLog create(InventoryLog log);

    List<InventoryLog> getAll();

    InventoryLog getById(UUID id);

    boolean delete(UUID id);
}