package com.store.videogames.modules.sale_detail.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.store.videogames.modules.sale_detail.dto.SaleDetailDTO;
import com.store.videogames.modules.sale_detail.dto.SaleDetailViews;
import com.store.videogames.modules.sale_detail.services.Implement.SaleDetailImplement;
import com.store.videogames.shared.controller.AbstractController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sale-detail")
public class SaleDetailController extends AbstractController<SaleDetailDTO, String> {

    @Autowired private SaleDetailImplement service;

    @Override
    @PostMapping("/create")
    public ResponseEntity<String> create(@Valid @RequestBody SaleDetailDTO dto) {
        return created(service.Create(dto));
    }

    @Override
    @JsonView(SaleDetailViews.Summary.class)
    @GetMapping("/getAll")
    public ResponseEntity<List<SaleDetailDTO>> getAll() {
        return ok(service.GetAll());
    }

    @Override
    @JsonView(SaleDetailViews.Detail.class)
    @GetMapping("/getById/{id}")
    public ResponseEntity<SaleDetailDTO> getById(@PathVariable String id) {
        return ok(service.GetById(id));
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @Valid @RequestBody SaleDetailDTO dto) {
        return ok(service.Update(id, dto));
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return ok(service.Delete(id) ? "Eliminado correctamente" : "No encontrado");
    }
}