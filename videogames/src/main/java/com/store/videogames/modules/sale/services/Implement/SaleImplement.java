package com.store.videogames.modules.sale.services.Implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.videogames.modules.customer.entity.Customer;
import com.store.videogames.modules.customer.repository.CustomerRepository;
import com.store.videogames.modules.sale.dto.SaleDTO;
import com.store.videogames.modules.sale.mapper.SaleMapper;
import com.store.videogames.modules.sale.repository.SaleRepository;
import com.store.videogames.modules.sale.services.Interface.ISale;

@Service
public class SaleImplement implements ISale {

    @Autowired
    private SaleRepository data;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SaleMapper mapper;

    private Customer findCustomer(String id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer no encontrado con id: " + id));
    }

    @Override
    public String Create(SaleDTO dto) {
        try {
            Customer customer = findCustomer(dto.getId_customer());
            data.save(mapper.toEntity(dto, customer));
            return "Sale creada correctamente";
        } catch (Exception e) {
            return "Error al crear sale: " + e.getMessage();
        }
    }

    @Override
    public List<SaleDTO> GetAll() {
        return data.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SaleDTO GetById(String id) {
        return data.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Sale no encontrada con id: " + id));
    }

    @Override
    public String Update(String id, SaleDTO dto) {
        var sale = data.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale no encontrada con id: " + id));
        Customer customer = findCustomer(dto.getId_customer());
        sale.setTotal(dto.getTotal());
        sale.setStatus(dto.getStatus());
        sale.setPayment_method(dto.getPayment_method());
        sale.setCurrency(dto.getCurrency());
        sale.setId_customer(customer);
        data.save(sale);
        return "Sale actualizada correctamente";
    }

    @Override
    public boolean Delete(String id) {
        if (!data.existsById(id)) return false;
        data.deleteById(id);
        return true;
    }
}