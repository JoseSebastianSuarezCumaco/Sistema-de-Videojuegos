package com.store.videogames.modules.wishlist.services.Implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.videogames.modules.wishlist.entity.Wishlist;
import com.store.videogames.modules.wishlist.repository.WishlistRepository;
import com.store.videogames.modules.wishlist.services.Interface.IWishlist;

@Service
public class WishlistImplement implements IWishlist {

    @Autowired
    WishlistRepository data;

    @Override
    public String Create(Wishlist wishlist) {
        try {
            data.save(wishlist);
            return "Wishlist created successfully";
        } catch (Exception e) {
            return "Error creating wishlist: " + e.getMessage();
        }
    }

    @Override
    public List<Wishlist> GetAll() {
        return data.findAll();
    }

    @Override
    public Wishlist GetById(String wishlistId) {
        Optional<Wishlist> wishlist = data.findById(wishlistId);

        if (!wishlist.isPresent()) {
            throw new RuntimeException("Wishlist not found with id: " + wishlistId);
        }

        return wishlist.get();
    }

    @Override
    public Wishlist Update(String wishlistId) {
        throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    @Override
    public Wishlist PartialUpdate(String wishlistId) {
        throw new UnsupportedOperationException("Unimplemented method 'PartialUpdate'");
    }

    @Override
    public boolean Delete(String wishlistId) {
        throw new UnsupportedOperationException("Unimplemented method 'Delete'");
    }

    @Override
    public boolean LogicalDelete(String wishlistId) {
        throw new UnsupportedOperationException("Unimplemented method 'LogicalDelete'");
    }
}