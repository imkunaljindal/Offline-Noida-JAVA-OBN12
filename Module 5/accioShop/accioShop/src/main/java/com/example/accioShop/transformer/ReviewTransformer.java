package com.example.accioShop.transformer;

import com.example.accioShop.dto.request.ReviewRequest;
import com.example.accioShop.dto.response.ReviewResponse;
import com.example.accioShop.model.Review;

public class ReviewTransformer {

    public static Review reviewRequestToReview(ReviewRequest reviewRequest) {
        return Review.builder()
                .comment(reviewRequest.getComment())
                .rating(reviewRequest.getRating())
                .build();
    }

    public static ReviewResponse reviewToReviewResponse(Review review) {
        return ReviewResponse.builder()
                .comment(review.getComment())
                .rating(review.getRating())
                .product(ProductTransformer.productToProductResponse(review.getProduct()))
                .build();
    }
}
