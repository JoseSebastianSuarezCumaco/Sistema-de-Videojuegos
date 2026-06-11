package com.store.videogames.modules.inventory.services.Interface;

import java.util.List;
import java.util.UUID;

import com.store.videogames.modules.inventory.entity.Inventory;

public interface IInventory {

    Inventory create(Inventory inventory);

    List<Inventory> getAll();

    Inventory getById(UUID id);

    Inventory update(UUID id, Inventory inventory);

    Inventory partialUpdate(UUID id, Inventory inventory);

    boolean delete(UUID id);
}