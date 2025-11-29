package com.example.accioShop.controller;

import com.example.accioShop.dto.request.ReviewRequest;
import com.example.accioShop.dto.response.ReviewResponse;
import com.example.accioShop.exception.ReviewNotFoundException;
import com.example.accioShop.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {



    @Autowired
    ReviewService reviewService;

    @GetMapping
    public ResponseEntity getReviewById(@RequestParam("id") int id) {
        try {
            return new ResponseEntity(reviewService.getReviewsById(id), HttpStatus.FOUND);
        } catch (ReviewNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity addReview(@RequestParam("c-id") int customerId,
                                    @RequestParam("p-id") int productId,
                                    @RequestBody ReviewRequest reviewRequest) {
        try {
            ReviewResponse response = reviewService.addReview(customerId, productId, reviewRequest);
            return new ResponseEntity(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
