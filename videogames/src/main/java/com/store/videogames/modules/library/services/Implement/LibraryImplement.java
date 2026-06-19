package com.store.videogames.modules.library.services.Implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.videogames.modules.library.entity.Library;
import com.store.videogames.modules.library.repository.LibraryRepository;
import com.store.videogames.modules.library.services.Interface.ILibrary;

@Service
public class LibraryImplement implements ILibrary {

    @Autowired
    LibraryRepository data;

    @Override
    public String Create(Library library) {
        try {
            data.save(library);
            return "Library created successfully";
        } catch (Exception e) {
            return "Error creating library: " + e.getMessage();
        }
    }

    @Override
    public List<Library> GetAll() {
        return data.findAll();
    }

    @Override
    public Library GetById(String libraryId) {
        Optional<Library> library = data.findById(libraryId);

        if (!library.isPresent()) {
            throw new RuntimeException("Library not found with id: " + libraryId);
        }

        return library.get();
    }

    @Override
    public Library Update(String libraryId) {
        throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    @Override
    public Library PartialUpdate(String libraryId) {
        throw new UnsupportedOperationException("Unimplemented method 'PartialUpdate'");
    }

    @Override
    public boolean Delete(String libraryId) {
        throw new UnsupportedOperationException("Unimplemented method 'Delete'");
    }

    @Override
    public boolean LogicalDelete(String libraryId) {
        throw new UnsupportedOperationException("Unimplemented method 'LogicalDelete'");
    }
}
