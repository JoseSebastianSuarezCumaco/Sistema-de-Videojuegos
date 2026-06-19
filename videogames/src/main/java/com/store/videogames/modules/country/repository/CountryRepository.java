package com.store.videogames.modules.country.repository;

import com.store.videogames.modules.country.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {}