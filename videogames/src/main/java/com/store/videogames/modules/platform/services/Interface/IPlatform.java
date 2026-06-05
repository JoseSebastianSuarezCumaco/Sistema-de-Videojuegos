package com.store.videogames.modules.platform.services.Interface;
import java.util.List;
import com.store.videogames.modules.platform.entity.Platform;

public interface IPlatform {
    public String Create(Platform platform);
    public List<Platform> GetAll();
    public Platform GetById(Integer platformId);
    public Platform Update(Integer platformId);
    public Platform PartialUpdate(Integer platformId);
    public boolean Delete(Integer platformId);
    public boolean LogicalDelete(Integer platformId);
}