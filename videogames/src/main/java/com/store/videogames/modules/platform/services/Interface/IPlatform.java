package com.store.videogames.modules.platform.services.Interface;

import java.util.List;

import com.store.videogames.modules.platform.dto.PlatformDTO;

public interface IPlatform {
    String Create(PlatformDTO dto);
    List<PlatformDTO> GetAll();
    PlatformDTO GetById(Integer id);
    String Update(Integer id, PlatformDTO dto);
    boolean Delete(Integer id);
}