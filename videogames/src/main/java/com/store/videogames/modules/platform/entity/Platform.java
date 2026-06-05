package com.store.videogames.modules.platform.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "platform")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_platform")
    private int id_platform;

    @Column(name = "name", length = 150)
    private String name;

    @Column(name = "slug", length = 150)
    private String slug;

    @Column(name = "icon_url", length = 255)
    private String icon_url;

    @Column(name = "status")
    private boolean status;
}