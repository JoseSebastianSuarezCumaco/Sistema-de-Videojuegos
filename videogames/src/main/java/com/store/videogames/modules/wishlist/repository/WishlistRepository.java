package com.store.videogames.modules.wishlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.videogames.modules.wishlist.entity.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, String> {

}