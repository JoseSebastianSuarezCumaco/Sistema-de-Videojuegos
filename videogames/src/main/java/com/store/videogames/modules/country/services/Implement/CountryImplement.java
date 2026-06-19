package com.store.videogames.modules.country.services.Implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.videogames.modules.country.dto.CountryDTO;
import com.store.videogames.modules.country.mapper.CountryMapper;
import com.store.videogames.modules.country.repository.CountryRepository;
import com.store.videogames.modules.country.services.Interface.ICountry;

@Service
public class CountryImplement implements ICountry {

    @Autowired
    private CountryRepository data;

    @Autowired
    private CountryMapper mapper;

    @Override
    public String Create(CountryDTO dto) {
        try {
            data.save(mapper.toEntity(dto));
            return "Country creado correctamente";
        } catch (Exception e) {
            return "Error al crear country: " + e.getMessage();
        }
    }

    @Override
    public List<CountryDTO> GetAll() {
        return data.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CountryDTO GetById(Integer id) {
        return data.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Country no encontrado con id: " + id));
    }

    @Override
    public String Update(Integer id, CountryDTO dto) {
        var country = data.findById(id)
                .orElseThrow(() -> new RuntimeException("Country no encontrado con id: " + id));
        country.setName(dto.getName());
        country.setCode(dto.getCode());
        country.setStatus(dto.isStatus());
        data.save(country);
        return "Country actualizado correctamente";
    }

    @Override
    public boolean Delete(Integer id) {
        if (!data.existsById(id)) return false;
        data.deleteById(id);
        return true;
    }
}