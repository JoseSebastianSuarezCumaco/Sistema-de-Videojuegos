package com.store.videogames.modules.sale_detail.services.Interface;

import java.util.List;

import com.store.videogames.modules.sale_detail.dto.SaleDetailDTO;

public interface ISaleDetail {
    String Create(SaleDetailDTO dto);
    List<SaleDetailDTO> GetAll();
    SaleDetailDTO GetById(String id);
    String Update(String id, SaleDetailDTO dto);
    boolean Delete(String id);
}