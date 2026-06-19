package com.store.videogames.modules.customer.services.Interface;

import java.util.List;

import com.store.videogames.modules.customer.dto.CustomerDTO;

public interface ICustomer {
    String Create(CustomerDTO dto);
    List<CustomerDTO> GetAll();
    CustomerDTO GetById(String id);
    String Update(String id, CustomerDTO dto);
    boolean Delete(String id);
}