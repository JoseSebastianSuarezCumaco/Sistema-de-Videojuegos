package com.store.videogames.modules.library.services.Interface;

import java.util.List;

import com.store.videogames.modules.library.entity.Library;

public interface ILibrary {

    public String Create(Library library);

    public List<Library> GetAll();

    public Library GetById(String libraryId);

    public Library Update(String libraryId);

    public Library PartialUpdate(String libraryId);

    public boolean Delete(String libraryId);

    public boolean LogicalDelete(String libraryId);
}