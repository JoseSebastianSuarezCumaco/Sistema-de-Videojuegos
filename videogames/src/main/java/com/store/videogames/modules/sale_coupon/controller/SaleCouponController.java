package com.store.videogames.modules.sale_coupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.store.videogames.modules.sale_coupon.dto.SaleCouponDTO;
import com.store.videogames.modules.sale_coupon.dto.SaleCouponViews;
import com.store.videogames.modules.sale_coupon.services.Implement.SaleCouponImplement;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/sale-coupon")
public class SaleCouponController {

    @Autowired private SaleCouponImplement service;

    @PostMapping("/create")
    public ResponseEntity<String> create(@Valid @RequestBody SaleCouponDTO dto) {
        return new ResponseEntity<>(service.Create(dto), HttpStatus.CREATED);
    }

    @JsonView(SaleCouponViews.Summary.class)
    @GetMapping("/getAll")
    public ResponseEntity<List<SaleCouponDTO>> getAll() {
        return new ResponseEntity<>(service.GetAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idSale}/{idCoupon}")
    public ResponseEntity<String> delete(@PathVariable String idSale, @PathVariable String idCoupon) {
        return new ResponseEntity<>(
            service.Delete(idSale, idCoupon) ? "Eliminado correctamente" : "No encontrado",
            HttpStatus.OK
        );
    }
}