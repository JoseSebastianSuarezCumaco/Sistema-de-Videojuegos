package com.store.videogames.modules.platform.services.Implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.videogames.modules.platform.dto.PlatformDTO;
import com.store.videogames.modules.platform.mapper.PlatformMapper;
import com.store.videogames.modules.platform.repository.PlatformRepository;
import com.store.videogames.modules.platform.services.Interface.IPlatform;

@Service
public class PlatformImplement implements IPlatform {

    @Autowired
    private PlatformRepository data;

    @Autowired
    private PlatformMapper mapper;

    @Override
    public String Create(PlatformDTO dto) {
        try {
            data.save(mapper.toEntity(dto));
            return "Platform creada correctamente";
        } catch (Exception e) {
            return "Error al crear platform: " + e.getMessage();
        }
    }

    @Override
    public List<PlatformDTO> GetAll() {
        return data.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PlatformDTO GetById(Integer id) {
        return data.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Platform no encontrada con id: " + id));
    }

    @Override
    public String Update(Integer id, PlatformDTO dto) {
        var platform = data.findById(id)
                .orElseThrow(() -> new RuntimeException("Platform no encontrada con id: " + id));
        platform.setName(dto.getName());
        platform.setSlug(dto.getSlug());
        platform.setIcon_url(dto.getIcon_url());
        platform.setStatus(dto.isStatus());
        data.save(platform);
        return "Platform actualizada correctamente";
    }

    @Override
    public boolean Delete(Integer id) {
        if (!data.existsById(id)) return false;
        data.deleteById(id);
        return true;
    }
}