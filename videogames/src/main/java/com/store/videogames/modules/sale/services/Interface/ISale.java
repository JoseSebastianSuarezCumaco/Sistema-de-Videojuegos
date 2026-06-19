package com.store.videogames.modules.sale.services.Interface;

import java.util.List;

import com.store.videogames.modules.sale.dto.SaleDTO;

public interface ISale {
    String Create(SaleDTO dto);
    List<SaleDTO> GetAll();
    SaleDTO GetById(String id);
    String Update(String id, SaleDTO dto);
    boolean Delete(String id);
}