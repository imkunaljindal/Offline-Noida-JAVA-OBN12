package com.example.accioShop.exception;

import com.example.accioShop.repository.SellerRepository;

public class SellerNotFoundException extends RuntimeException{

    public SellerNotFoundException(String message) {
        super(message);
    }
}
