package com.store.videogames.modules.platform.services.Interface;

import com.store.videogames.modules.platform.dto.PlatformDTO;
import java.util.List;

public interface IPlatform {
    String Create(PlatformDTO dto);
    List<PlatformDTO> GetAll();
    PlatformDTO GetById(String id);
    String Update(String id, PlatformDTO dto);
    boolean Delete(String id);
}