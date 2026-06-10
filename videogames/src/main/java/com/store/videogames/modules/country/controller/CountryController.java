package com.store.videogames.modules.country.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.videogames.modules.country.entity.Country;
import com.store.videogames.modules.country.services.Implement.CountryImplement;

@RestController
@RequestMapping("/api/v1/country")
public class CountryController {

    @Autowired
    CountryImplement service;

    @PostMapping("/create")
    public ResponseEntity<Object> Create(@RequestBody Country country) {
        String retorno = service.Create(country);
        return new ResponseEntity<Object>(retorno, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Country>> GetAll() {
        var retorno = service.GetAll();
        return new ResponseEntity<List<Country>>(retorno, HttpStatus.OK);
    }
}