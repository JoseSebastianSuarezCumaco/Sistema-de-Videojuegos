package com.store.videogames.modules.platform.mapper;

import com.store.videogames.modules.platform.dto.PlatformDTO;
import com.store.videogames.modules.platform.entity.Platform;
import org.springframework.stereotype.Component;

@Component
public class PlatformMapper {

    public PlatformDTO toDTO(Platform platform) {
        PlatformDTO dto = new PlatformDTO();
        dto.setId_platform(platform.getId_platform());
        dto.setName(platform.getName());
        dto.setSlug(platform.getSlug());
        dto.setIcon_url(platform.getIcon_url());
        return dto;
    }

    public Platform toEntity(PlatformDTO dto) {
        Platform platform = new Platform();
        platform.setName(dto.getName());
        platform.setSlug(dto.getSlug());
        platform.setIcon_url(dto.getIcon_url());
        return platform;
    }
}