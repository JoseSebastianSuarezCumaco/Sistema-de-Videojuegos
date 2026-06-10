package com.store.videogames.modules.country.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.store.videogames.modules.country.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}