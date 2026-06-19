package com.store.videogames.modules.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.videogames.modules.review.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, String> {

}
