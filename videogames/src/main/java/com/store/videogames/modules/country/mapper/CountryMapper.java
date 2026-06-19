package com.store.videogames.modules.country.mapper;

import com.store.videogames.modules.country.dto.CountryDTO;
import com.store.videogames.modules.country.entity.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {

    public CountryDTO toDTO(Country country) {
        CountryDTO dto = new CountryDTO();
        dto.setId_country(country.getId_country());
        dto.setName(country.getName());
        dto.setCode(country.getCode());
        return dto;
    }

    public Country toEntity(CountryDTO dto) {
        Country country = new Country();
        country.setName(dto.getName());
        country.setCode(dto.getCode());
        return country;
    }
}