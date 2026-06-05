package com.store.videogames.modules.platform.services.Implement;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.store.videogames.modules.platform.entity.Platform;
import com.store.videogames.modules.platform.repository.PlatformRepository;
import com.store.videogames.modules.platform.services.Interface.IPlatform;

@Service
public class PlatformImplement implements IPlatform {

    @Autowired
    PlatformRepository data;

    @Override
    public String Create(Platform platform) {
        try {
            data.save(platform);
            return "Platform created successfully";
        } catch (Exception e) {
            return "Error creating platform: " + e.getMessage();
        }
    }

    @Override
    public List<Platform> GetAll() {
        return data.findAll();
    }

    @Override
    public Platform GetById(Integer platformId) {
        Optional<Platform> platform = data.findById(platformId);
        if (!platform.isPresent()) {
            throw new RuntimeException("Platform not found with id: " + platformId);
        }
        return platform.get();
    }

    @Override
    public Platform Update(Integer platformId) {
        throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    @Override
    public Platform PartialUpdate(Integer platformId) {
        throw new UnsupportedOperationException("Unimplemented method 'PartialUpdate'");
    }

    @Override
    public boolean Delete(Integer platformId) {
        throw new UnsupportedOperationException("Unimplemented method 'Delete'");
    }

    @Override
    public boolean LogicalDelete(Integer platformId) {
        throw new UnsupportedOperationException("Unimplemented method 'LogicalDelete'");
    }
}