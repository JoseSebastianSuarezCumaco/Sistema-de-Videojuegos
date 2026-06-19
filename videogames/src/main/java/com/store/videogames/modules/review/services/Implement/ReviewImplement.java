package com.store.videogames.modules.review.services.Implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.videogames.modules.review.entity.Review;
import com.store.videogames.modules.review.repository.ReviewRepository;
import com.store.videogames.modules.review.services.Interface.IReview;

@Service
public class ReviewImplement implements IReview {

    @Autowired
    ReviewRepository data;

    @Override
    public String Create(Review review) {
        try {
            data.save(review);
            return "Review created successfully";
        } catch (Exception e) {
            return "Error creating review: " + e.getMessage();
        }
    }

    @Override
    public List<Review> GetAll() {
        return data.findAll();
    }

    @Override
    public Review GetById(String reviewId) {
        Optional<Review> review = data.findById(reviewId);

        if (!review.isPresent()) {
            throw new RuntimeException("Review not found with id: " + reviewId);
        }

        return review.get();
    }

    @Override
    public Review Update(String reviewId) {
        throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    @Override
    public Review PartialUpdate(String reviewId) {
        throw new UnsupportedOperationException("Unimplemented method 'PartialUpdate'");
    }

    @Override
    public boolean Delete(String reviewId) {
        throw new UnsupportedOperationException("Unimplemented method 'Delete'");
    }

    @Override
    public boolean LogicalDelete(String reviewId) {
        throw new UnsupportedOperationException("Unimplemented method 'LogicalDelete'");
    }
}