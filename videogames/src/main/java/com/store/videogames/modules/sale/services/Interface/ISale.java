package com.store.videogames.modules.sale.services.Interface;

import java.util.List;
import com.store.videogames.modules.sale.entity.Sale;

public interface ISale {
    public String Create(Sale sale);
    public List<Sale> GetAll();
    public Sale GetById(String saleId);
    public Sale Update(String saleId);
    public Sale PartialUpdate(String saleId);
    public boolean Delete(String saleId);
    public boolean LogicalDelete(String saleId);
}