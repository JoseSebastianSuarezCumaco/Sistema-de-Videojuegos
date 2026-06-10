package com.store.videogames.modules.sale.services.Implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.videogames.modules.sale.entity.Sale;
import com.store.videogames.modules.sale.repository.SaleRepository;
import com.store.videogames.modules.sale.services.Interface.ISale;

@Service
public class SaleImplement implements ISale {

    @Autowired
    SaleRepository data;

    @Override
    public String Create(Sale sale) {
        try {
            data.save(sale);
            return "Sale created successfully";
        } catch (Exception e) {
            return "Error creating sale: " + e.getMessage();
        }
    }

    @Override
    public List<Sale> GetAll() {
        return data.findAll();
    }

    @Override
    public Sale GetById(String saleId) {
        Optional<Sale> sale = data.findById(saleId);
        if (!sale.isPresent()) {
            throw new RuntimeException("Sale not found with id: " + saleId);
        }
        return sale.get();
    }

    @Override
    public Sale Update(String saleId) {
        throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    @Override
    public Sale PartialUpdate(String saleId) {
        throw new UnsupportedOperationException("Unimplemented method 'PartialUpdate'");
    }

    @Override
    public boolean Delete(String saleId) {
        throw new UnsupportedOperationException("Unimplemented method 'Delete'");
    }

    @Override
    public boolean LogicalDelete(String saleId) {
        throw new UnsupportedOperationException("Unimplemented method 'LogicalDelete'");
    }
}