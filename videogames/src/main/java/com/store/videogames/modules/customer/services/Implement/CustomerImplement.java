package com.store.videogames.modules.customer.services.Implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.videogames.modules.country.entity.Country;
import com.store.videogames.modules.country.repository.CountryRepository;
import com.store.videogames.modules.customer.dto.CustomerDTO;
import com.store.videogames.modules.customer.mapper.CustomerMapper;
import com.store.videogames.modules.customer.repository.CustomerRepository;
import com.store.videogames.modules.customer.services.Interface.ICustomer;

@Service
public class CustomerImplement implements ICustomer {

    @Autowired
    private CustomerRepository data;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CustomerMapper mapper;

    private Country findCountry(Integer id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country no encontrado con id: " + id));
    }

    @Override
    public String Create(CustomerDTO dto) {
        try {
            Country country = findCountry(dto.getId_country());
            data.save(mapper.toEntity(dto, country));
            return "Customer creado correctamente";
        } catch (Exception e) {
            return "Error al crear customer: " + e.getMessage();
        }
    }

    @Override
    public List<CustomerDTO> GetAll() {
        return data.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO GetById(String id) {
        return data.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Customer no encontrado con id: " + id));
    }

    @Override
    public String Update(String id, CustomerDTO dto) {
        var customer = data.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer no encontrado con id: " + id));
        Country country = findCountry(dto.getId_country());
        customer.setName(dto.getName());
        customer.setProfile_name(dto.getProfile_name());
        customer.setLast_name(dto.getLast_name());
        customer.setEmail(dto.getEmail());
        customer.setId_country(country);
        data.save(customer);
        return "Customer actualizado correctamente";
    }

    @Override
    public boolean Delete(String id) {
        if (!data.existsById(id)) return false;
        data.deleteById(id);
        return true;
    }
}