package com.store.videogames.modules.sale.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.store.videogames.modules.sale.dto.SaleDTO;
import com.store.videogames.modules.sale.dto.SaleViews;
import com.store.videogames.modules.sale.services.Implement.SaleImplement;
import com.store.videogames.shared.controller.AbstractController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sale")
public class SaleController extends AbstractController<SaleDTO, String> {

    @Autowired
    private SaleImplement service;

    @Override
    @PostMapping("/create")
    public ResponseEntity<String> create(@Valid @RequestBody SaleDTO dto) {
        return created(service.Create(dto));
    }

    @Override
    @JsonView(SaleViews.Summary.class)
    @GetMapping("/getAll")
    public ResponseEntity<List<SaleDTO>> getAll() {
        return ok(service.GetAll());
    }

    @Override
    @JsonView(SaleViews.Detail.class)
    @GetMapping("/getById/{id}")
    public ResponseEntity<SaleDTO> getById(@PathVariable String id) {
        return ok(service.GetById(id));
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @Valid @RequestBody SaleDTO dto) {
        return ok(service.Update(id, dto));
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return ok(service.Delete(id) ? "Eliminado correctamente" : "No encontrado");
    }
}