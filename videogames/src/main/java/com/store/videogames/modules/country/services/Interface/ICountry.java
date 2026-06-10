package com.store.videogames.modules.country.services.Interface;

import java.util.List;
import com.store.videogames.modules.country.entity.Country;

public interface ICountry {
    public String Create(Country country);
    public List<Country> GetAll();
    public Country GetById(Integer countryId);
    public Country Update(Integer countryId);
    public Country PartialUpdate(Integer countryId);
    public boolean Delete(Integer countryId);
    public boolean LogicalDelete(Integer countryId);
}