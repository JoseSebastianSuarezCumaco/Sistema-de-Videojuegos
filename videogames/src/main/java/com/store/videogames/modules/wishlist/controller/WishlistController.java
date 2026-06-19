package com.store.videogames.modules.wishlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.store.videogames.modules.wishlist.entity.Wishlist;
import com.store.videogames.modules.wishlist.services.Implement.WishlistImplement;

@RestController
@RequestMapping("/api/v1/wishlist")
public class WishlistController {

    @Autowired
    WishlistImplement service;

    @PostMapping("/create")
    public ResponseEntity<Object> Create(@RequestBody Wishlist wishlist) {
        String retorno = service.Create(wishlist);
        return new ResponseEntity<Object>(retorno, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Wishlist>> GetAll() {
        var retorno = service.GetAll();
        return new ResponseEntity<List<Wishlist>>(retorno, HttpStatus.OK);
    }
}