package com.store.videogames.modules.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.store.videogames.modules.review.entity.Review;
import com.store.videogames.modules.review.services.Implement.ReviewImplement;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

    @Autowired
    ReviewImplement service;

    @PostMapping("/create")
    public ResponseEntity<Object> Create(@RequestBody Review review) {
        String retorno = service.Create(review);
        return new ResponseEntity<Object>(retorno, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Review>> GetAll() {
        var retorno = service.GetAll();
        return new ResponseEntity<List<Review>>(retorno, HttpStatus.OK);
    }
}