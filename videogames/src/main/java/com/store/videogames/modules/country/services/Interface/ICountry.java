package com.store.videogames.modules.country.services.Interface;

import java.util.List;

import com.store.videogames.modules.country.dto.CountryDTO;

public interface ICountry {
    String Create(CountryDTO dto);
    List<CountryDTO> GetAll();
    CountryDTO GetById(Integer id);
    String Update(Integer id, CountryDTO dto);
    boolean Delete(Integer id);
}