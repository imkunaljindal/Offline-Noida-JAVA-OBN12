package com.example.accioShop.controller;

import com.example.accioShop.model.Seller;
import com.example.accioShop.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping
    public ResponseEntity addSeller(@RequestBody Seller seller) {
        Seller savedSeller = sellerService.addSeller(seller);
        return new ResponseEntity(savedSeller, HttpStatus.CREATED);
    }
}
