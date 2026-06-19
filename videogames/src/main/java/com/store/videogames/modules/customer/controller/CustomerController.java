package com.store.videogames.modules.customer.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.store.videogames.modules.customer.dto.CustomerDTO;
import com.store.videogames.modules.customer.dto.CustomerViews;
import com.store.videogames.modules.customer.services.Implement.CustomerImplement;
import com.store.videogames.shared.controller.AbstractController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController extends AbstractController<CustomerDTO, String> {

    @Autowired
    private CustomerImplement service;

    @Override
    @PostMapping("/create")
    public ResponseEntity<String> create(@Valid @RequestBody CustomerDTO dto) {
        return created(service.Create(dto));
    }

    @Override
    @JsonView(CustomerViews.Summary.class)
    @GetMapping("/getAll")
    public ResponseEntity<List<CustomerDTO>> getAll() {
        return ok(service.GetAll());
    }

    @Override
    @JsonView(CustomerViews.Detail.class)
    @GetMapping("/getById/{id}")
    public ResponseEntity<CustomerDTO> getById(@PathVariable String id) {
        return ok(service.GetById(id));
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @Valid @RequestBody CustomerDTO dto) {
        return ok(service.Update(id, dto));
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return ok(service.Delete(id) ? "Eliminado correctamente" : "No encontrado");
    }
}