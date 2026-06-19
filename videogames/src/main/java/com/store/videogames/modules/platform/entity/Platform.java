package com.store.videogames.modules.platform.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "platform")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_platform")
    private String id_platform;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "slug", length = 20)
    private String slug;

    @Column(name = "icon_url", length = 255)
    private String icon_url;
}