package com.example.accioShop.service;

import com.example.accioShop.exception.ReviewNotFoundException;
import com.example.accioShop.model.Review;
import com.example.accioShop.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public Review getReviewsById(int id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if(reviewOptional.isEmpty()) {
            throw new ReviewNotFoundException("Invalid review id");
        }
        return reviewOptional.get();
    }
}
