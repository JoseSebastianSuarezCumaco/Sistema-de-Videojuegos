package com.store.videogames.modules.sale.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {

    @JsonView(SaleViews.Summary.class)
    private String id_sale;

    @JsonView(SaleViews.Summary.class)
    private LocalDateTime sale_date;

    @JsonView(SaleViews.Summary.class)
    @NotNull(message = "El total es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El total debe ser mayor a 0")
    private BigDecimal total;

    @JsonView(SaleViews.Summary.class)
    @NotBlank(message = "El id del customer es obligatorio")
    private String id_customer;

    @JsonView(SaleViews.Summary.class)
    @NotBlank(message = "El estado es obligatorio")
    @Size(max = 30)
    private String status;

    @JsonView(SaleViews.Detail.class)
    @NotBlank(message = "El método de pago es obligatorio")
    @Size(max = 54)
    private String payment_method;

    @JsonView(SaleViews.Detail.class)
    @NotBlank(message = "La moneda es obligatoria")
    @Size(max = 30)
    private String currency;
}