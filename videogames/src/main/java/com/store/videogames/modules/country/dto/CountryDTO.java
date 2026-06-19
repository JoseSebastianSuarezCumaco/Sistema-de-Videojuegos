package com.store.videogames.modules.country.dto;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CountryDTO {

    @JsonView(CountryViews.Summary.class)
    private String id_country;

    @JsonView(CountryViews.Summary.class)
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50, message = "El nombre no puede superar 50 caracteres")
    private String name;

    @JsonView(CountryViews.Summary.class)
    @NotBlank(message = "El código es obligatorio")
    @Size(max = 10, message = "El código no puede superar 10 caracteres")
    private String code;
}