package com.store.videogames.modules.country.services.Implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.videogames.modules.country.entity.Country;
import com.store.videogames.modules.country.repository.CountryRepository;
import com.store.videogames.modules.country.services.Interface.ICountry;

@Service
public class CountryImplement implements ICountry {

    @Autowired
    CountryRepository data;

    @Override
    public String Create(Country country) {
        try {
            data.save(country);
            return "Country created successfully";
        } catch (Exception e) {
            return "Error creating country: " + e.getMessage();
        }
    }

    @Override
    public List<Country> GetAll() {
        return data.findAll();
    }

    @Override
    public Country GetById(Integer countryId) {
        Optional<Country> country = data.findById(countryId);
        if (!country.isPresent()) {
            throw new RuntimeException("Country not found with id: " + countryId);
        }
        return country.get();
    }

    @Override
    public Country Update(Integer countryId) {
        throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    @Override
    public Country PartialUpdate(Integer countryId) {
        throw new UnsupportedOperationException("Unimplemented method 'PartialUpdate'");
    }

    @Override
    public boolean Delete(Integer countryId) {
        throw new UnsupportedOperationException("Unimplemented method 'Delete'");
    }

    @Override
    public boolean LogicalDelete(Integer countryId) {
        throw new UnsupportedOperationException("Unimplemented method 'LogicalDelete'");
    }
}