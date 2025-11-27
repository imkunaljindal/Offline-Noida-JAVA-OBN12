package com.example.accioShop.controller;

import com.example.accioShop.dto.request.ProductRequest;
import com.example.accioShop.dto.response.ProductResponse;
import com.example.accioShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    // H.W - Make Add Product
    // Make add Customer Address API

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity addProduct(@RequestParam("seller-id") int sellerId,
                                     @RequestBody ProductRequest productRequest) {
        try {
            ProductResponse response = productService.addProduct(sellerId, productRequest);
            return new ResponseEntity(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
