package com.store.videogames.modules.sale_detail.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class SaleDetailDTO {

    @JsonView(SaleDetailViews.Summary.class)
    private String id_detail;

    @JsonView(SaleDetailViews.Summary.class)
    @NotBlank(message = "El id de la venta es obligatorio")
    private String id_sale;

    @JsonView(SaleDetailViews.Summary.class)
    @NotBlank(message = "El id del juego es obligatorio")
    private String id_game;

    @JsonView(SaleDetailViews.Summary.class)
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private int quantity;

    @JsonView(SaleDetailViews.Summary.class)
    @NotNull(message = "El precio unitario es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor a 0")
    private BigDecimal unit_price;

    @JsonView(SaleDetailViews.Detail.class)
    @DecimalMin(value = "0.0", message = "El descuento no puede ser negativo")
    private BigDecimal discount_applied;
}