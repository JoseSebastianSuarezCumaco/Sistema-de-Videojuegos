package com.store.videogames.modules.customer.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.validation.constraints.Email;
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
public class CustomerDTO {

    @JsonView(CustomerViews.Summary.class)
    private String id_customer;

    @JsonView(CustomerViews.Summary.class)
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50, message = "El nombre no puede superar 50 caracteres")
    private String name;

    @JsonView(CustomerViews.Summary.class)
    @NotBlank(message = "El nombre de perfil es obligatorio")
    @Size(max = 50, message = "El nombre de perfil no puede superar 50 caracteres")
    private String profile_name;

    @JsonView(CustomerViews.Summary.class)
    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 50, message = "El apellido no puede superar 50 caracteres")
    private String last_name;

    @JsonView(CustomerViews.Detail.class)
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(max = 50)
    private String password;

    @JsonView(CustomerViews.Summary.class)
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no es válido")
    @Size(max = 50)
    private String email;

    @JsonView(CustomerViews.Detail.class)
    private LocalDate registration_date;

    @JsonView(CustomerViews.Summary.class)
    private boolean is_verified;

    @JsonView(CustomerViews.Summary.class)
    @NotNull(message = "El país es obligatorio")
    private Integer id_country;

    @JsonView(CustomerViews.Detail.class)
    private LocalDateTime deleted_at;
}