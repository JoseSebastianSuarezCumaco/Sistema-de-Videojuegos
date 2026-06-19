package com.store.videogames.shared.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

public abstract class AbstractController<DTO, ID> {

    public abstract ResponseEntity<String> create(@Valid @RequestBody DTO dto);
    public abstract ResponseEntity<List<DTO>> getAll();
    public abstract ResponseEntity<DTO> getById(@PathVariable ID id);
    public abstract ResponseEntity<String> update(@PathVariable ID id, @Valid @RequestBody DTO dto);
    public abstract ResponseEntity<String> delete(@PathVariable ID id);

    protected <T> ResponseEntity<T> ok(T body) {
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    protected ResponseEntity<String> created(String msg) {
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    protected ResponseEntity<String> notFound(String msg) {
        return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
    }
}