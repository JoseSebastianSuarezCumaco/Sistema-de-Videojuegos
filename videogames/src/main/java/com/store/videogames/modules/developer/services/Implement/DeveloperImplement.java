package com.store.videogames.modules.developer.services.Implement;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.videogames.modules.developer.entity.Developer;
import com.store.videogames.modules.developer.repository.DeveloperRepository;
import com.store.videogames.modules.developer.services.Interface.IDeveloper;

@Service
public class DeveloperImplement implements IDeveloper {

    @Autowired
    private DeveloperRepository repository;

    @Override
    public Developer create(Developer developer) {
        return repository.save(developer);
    }

    @Override
    public List<Developer> getAll() {
        return repository.findAll();
    }

    @Override
    public Developer getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Developer not found"));
    }

    @Override
    public Developer update(UUID id, Developer developer) {
        Developer existing = getById(id);

        existing.setName(developer.getName());
        existing.setCountry(developer.getCountry());
        existing.setWebsite_url(developer.getWebsite_url());
        existing.setDescription(developer.getDescription());
        existing.setLogo_url(developer.getLogo_url());

        return repository.save(existing);
    }

    @Override
    public Developer partialUpdate(UUID id, Developer developer) {
        Developer existing = getById(id);

        if (developer.getName() != null) {
            existing.setName(developer.getName());
        }
        if (developer.getCountry() != null) {
            existing.setCountry(developer.getCountry());
        }
        if (developer.getWebsite_url() != null) {
            existing.setWebsite_url(developer.getWebsite_url());
        }
        if (developer.getDescription() != null) {
            existing.setDescription(developer.getDescription());
        }
        if (developer.getLogo_url() != null) {
            existing.setLogo_url(developer.getLogo_url());
        }

        return repository.save(existing);
    }

    @Override
    public boolean delete(UUID id) {
        Developer existing = getById(id);
        repository.delete(existing);
        return true;
    }
}