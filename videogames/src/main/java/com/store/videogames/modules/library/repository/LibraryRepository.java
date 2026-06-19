package com.store.videogames.modules.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.videogames.modules.library.entity.Library;

public interface LibraryRepository extends JpaRepository<Library, String> {

}