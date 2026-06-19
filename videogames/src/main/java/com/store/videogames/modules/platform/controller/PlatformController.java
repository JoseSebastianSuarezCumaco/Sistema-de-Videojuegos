package com.store.videogames.modules.platform.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.store.videogames.modules.platform.dto.PlatformDTO;
import com.store.videogames.modules.platform.dto.PlatformViews;
import com.store.videogames.modules.platform.services.Implement.PlatformImplement;
import com.store.videogames.shared.controller.AbstractController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/platform")
public class PlatformController extends AbstractController<PlatformDTO, String> {

    @Autowired private PlatformImplement service;

    @Override @PostMapping("/create")
    public ResponseEntity<String> create(@Valid @RequestBody PlatformDTO dto) {
        return created(service.Create(dto));
    }

    @Override @JsonView(PlatformViews.Summary.class) @GetMapping("/getAll")
    public ResponseEntity<List<PlatformDTO>> getAll() {
        return ok(service.GetAll());
    }

    @Override @JsonView(PlatformViews.Detail.class) @GetMapping("/getById/{id}")
    public ResponseEntity<PlatformDTO> getById(@PathVariable String id) {
        return ok(service.GetById(id));
    }

    @Override @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @Valid @RequestBody PlatformDTO dto) {
        return ok(service.Update(id, dto));
    }

    @Override @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return ok(service.Delete(id) ? "Eliminado correctamente" : "No encontrado");
    }
}