package com.store.videogames.modules.customer.mapper;

import com.store.videogames.modules.country.entity.Country;
import com.store.videogames.modules.customer.dto.CustomerDTO;
import com.store.videogames.modules.customer.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDTO toDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId_customer(customer.getId_customer());
        dto.setName(customer.getName());
        dto.setProfile_name(customer.getProfile_name());
        dto.setLast_name(customer.getLast_name());
        dto.setPassword(customer.getPassword());
        dto.setEmail(customer.getEmail());
        dto.setRegistration_date(customer.getRegistration_date());
        dto.setIs_verified(customer.is_verified());
        dto.setDeleted_at(customer.getDeleted_at());
        if (customer.getId_country() != null) {
            dto.setId_country(customer.getId_country().getId_country());
        }
        return dto;
    }

    public Customer toEntity(CustomerDTO dto, Country country) {
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setProfile_name(dto.getProfile_name());
        customer.setLast_name(dto.getLast_name());
        customer.setPassword(dto.getPassword());
        customer.setEmail(dto.getEmail());
        customer.setRegistration_date(dto.getRegistration_date());
        customer.set_verified(dto.isIs_verified());
        customer.setId_country(country);
        return customer;
    }
}