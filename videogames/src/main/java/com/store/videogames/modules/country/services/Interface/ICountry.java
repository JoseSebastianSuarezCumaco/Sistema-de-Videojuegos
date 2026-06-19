package com.store.videogames.modules.country.services.Interface;

import com.store.videogames.modules.country.dto.CountryDTO;
import java.util.List;

public interface ICountry {
    String Create(CountryDTO dto);
    List<CountryDTO> GetAll();
    CountryDTO GetById(String id);
    String Update(String id, CountryDTO dto);
    boolean Delete(String id);
}