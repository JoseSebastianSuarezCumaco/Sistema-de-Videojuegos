package com.store.videogames.modules.country.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.store.videogames.modules.country.dto.CountryDTO;
import com.store.videogames.modules.country.dto.CountryViews;
import com.store.videogames.modules.country.services.Implement.CountryImplement;
import com.store.videogames.shared.controller.AbstractController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/country")
public class CountryController extends AbstractController<CountryDTO, String> {

    @Autowired private CountryImplement service;

    @Override @PostMapping("/create")
    public ResponseEntity<String> create(@Valid @RequestBody CountryDTO dto) {
        return created(service.Create(dto));
    }

    @Override @JsonView(CountryViews.Summary.class) @GetMapping("/getAll")
    public ResponseEntity<List<CountryDTO>> getAll() {
        return ok(service.GetAll());
    }

    @Override @JsonView(CountryViews.Detail.class) @GetMapping("/getById/{id}")
    public ResponseEntity<CountryDTO> getById(@PathVariable String id) {
        return ok(service.GetById(id));
    }

    @Override @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @Valid @RequestBody CountryDTO dto) {
        return ok(service.Update(id, dto));
    }

    @Override @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return ok(service.Delete(id) ? "Eliminado correctamente" : "No encontrado");
    }
}