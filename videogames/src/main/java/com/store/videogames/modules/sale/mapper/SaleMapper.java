package com.store.videogames.modules.sale.mapper;

import org.springframework.stereotype.Component;

import com.store.videogames.modules.customer.entity.Customer;
import com.store.videogames.modules.sale.dto.SaleDTO;
import com.store.videogames.modules.sale.entity.Sale;

@Component
public class SaleMapper {

    public SaleDTO toDTO(Sale sale) {
        SaleDTO dto = new SaleDTO();
        dto.setId_sale(sale.getId_sale());
        dto.setSale_date(sale.getSale_date());
        dto.setTotal(sale.getTotal());
        dto.setStatus(sale.getStatus());
        dto.setPayment_method(sale.getPayment_method());
        dto.setCurrency(sale.getCurrency());
        if (sale.getId_customer() != null) {
            dto.setId_customer(sale.getId_customer().getId_customer());
        }
        return dto;
    }

    public Sale toEntity(SaleDTO dto, Customer customer) {
        Sale sale = new Sale();
        sale.setSale_date(dto.getSale_date() != null ? dto.getSale_date() : java.time.LocalDateTime.now());
        sale.setTotal(dto.getTotal());
        sale.setStatus(dto.getStatus());
        sale.setPayment_method(dto.getPayment_method());
        sale.setCurrency(dto.getCurrency());
        sale.setId_customer(customer);
        return sale;
    }
}