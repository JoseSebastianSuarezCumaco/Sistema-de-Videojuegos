package com.store.videogames.modules.wishlist.services.Interface;

import java.util.List;

import com.store.videogames.modules.wishlist.entity.Wishlist;

public interface IWishlist {

    public String Create(Wishlist wishlist);

    public List<Wishlist> GetAll();

    public Wishlist GetById(String wishlistId);

    public Wishlist Update(String wishlistId);

    public Wishlist PartialUpdate(String wishlistId);

    public boolean Delete(String wishlistId);

    public boolean LogicalDelete(String wishlistId);
}