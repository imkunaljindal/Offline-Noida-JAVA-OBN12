package com.example.accioShop.service;

import com.example.accioShop.dto.request.ReviewRequest;
import com.example.accioShop.dto.response.ReviewResponse;
import com.example.accioShop.exception.CustomerNotFoundException;
import com.example.accioShop.exception.ProductNotFoundException;
import com.example.accioShop.exception.ReviewNotFoundException;
import com.example.accioShop.model.Customer;
import com.example.accioShop.model.Product;
import com.example.accioShop.model.Review;
import com.example.accioShop.repository.CustomerRepository;
import com.example.accioShop.repository.ProductRepository;
import com.example.accioShop.repository.ReviewRepository;
import com.example.accioShop.transformer.ReviewTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.OptionalInt;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    public Review getReviewsById(int id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if(reviewOptional.isEmpty()) {
            throw new ReviewNotFoundException("Invalid review id");
        }
        return reviewOptional.get();
    }

    public ReviewResponse addReview(int customerId,
                                    int productId,
                                    ReviewRequest reviewRequest) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if(customerOptional.isEmpty()) {
            throw new CustomerNotFoundException("Invalid customer id: "+customerId);
        }

        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Invalid product id: "+productId);
        }

        Customer customer = customerOptional.get();
        Product product = optionalProduct.get();

        Review review = ReviewTransformer.reviewRequestToReview(reviewRequest);

        // relationship
        review.setCustomer(customer);
        review.setProduct(product);

        // save review
        Review savedReview = reviewRepository.save(review); // product + customer + review

        // preapre response
        return ReviewTransformer.reviewToReviewResponse(savedReview);

    }
}
