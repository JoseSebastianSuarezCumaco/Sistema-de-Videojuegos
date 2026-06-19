package com.store.videogames.modules.platform.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.store.videogames.modules.platform.dto.PlatformViews;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlatformDTO {

    @JsonView(PlatformViews.Summary.class)
    private int id_platform;

    @JsonView(PlatformViews.Summary.class)
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 150, message = "El nombre no puede superar 150 caracteres")
    private String name;

    @JsonView(PlatformViews.Summary.class)
    @NotBlank(message = "El slug es obligatorio")
    @Size(max = 150, message = "El slug no puede superar 150 caracteres")
    private String slug;

    @JsonView(PlatformViews.Detail.class)
    @Size(max = 255, message = "La URL del ícono no puede superar 255 caracteres")
    private String icon_url;

    @JsonView(PlatformViews.Summary.class)
    private boolean status;
}