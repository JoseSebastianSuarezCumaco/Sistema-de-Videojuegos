package com.store.videogames.modules.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.videogames.modules.customer.entity.Customer;
import com.store.videogames.modules.customer.services.Implement.CustomerImplement;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerImplement service;

    @PostMapping("/create")
    public ResponseEntity<Object> Create(@RequestBody Customer customer) {
        String retorno = service.Create(customer);
        return new ResponseEntity<Object>(retorno, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> GetAll() {
        var retorno = service.GetAll();
        return new ResponseEntity<List<Customer>>(retorno, HttpStatus.OK);
    }
}