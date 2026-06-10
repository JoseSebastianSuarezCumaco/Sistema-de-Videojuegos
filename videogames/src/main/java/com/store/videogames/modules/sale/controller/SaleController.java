package com.store.videogames.modules.sale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.videogames.modules.sale.entity.Sale;
import com.store.videogames.modules.sale.services.Implement.SaleImplement;

@RestController
@RequestMapping("/api/v1/sale")
public class SaleController {

    @Autowired
    SaleImplement service;

    @PostMapping("/create")
    public ResponseEntity<Object> Create(@RequestBody Sale sale) {
        String retorno = service.Create(sale);
        return new ResponseEntity<Object>(retorno, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Sale>> GetAll() {
        var retorno = service.GetAll();
        return new ResponseEntity<List<Sale>>(retorno, HttpStatus.OK);
    }
}