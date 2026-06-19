package com.store.videogames.modules.platform.dto;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class PlatformDTO {

    @JsonView(PlatformViews.Summary.class)
    private String id_platform;

    @JsonView(PlatformViews.Summary.class)
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50, message = "El nombre no puede superar 50 caracteres")
    private String name;

    @JsonView(PlatformViews.Summary.class)
    @Size(max = 20, message = "El slug no puede superar 20 caracteres")
    private String slug;

    @JsonView(PlatformViews.Detail.class)
    @Size(max = 255, message = "La URL del ícono no puede superar 255 caracteres")
    private String icon_url;
}