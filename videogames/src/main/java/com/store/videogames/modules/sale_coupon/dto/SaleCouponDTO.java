package com.store.videogames.modules.sale_coupon.dto;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class SaleCouponDTO {

    @JsonView(SaleCouponViews.Summary.class)
    @NotBlank(message = "El id de la venta es obligatorio")
    private String id_sale;

    @JsonView(SaleCouponViews.Summary.class)
    @NotBlank(message = "El id del cupón es obligatorio")
    private String id_coupon;
}