package com.store.videogames.modules.review.services.Interface;

import java.util.List;

import com.store.videogames.modules.review.entity.Review;

public interface IReview {

    public String Create(Review review);

    public List<Review> GetAll();

    public Review GetById(String reviewId);

    public Review Update(String reviewId);

    public Review PartialUpdate(String reviewId);

    public boolean Delete(String reviewId);

    public boolean LogicalDelete(String reviewId);
}