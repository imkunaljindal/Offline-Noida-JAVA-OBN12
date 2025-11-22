package com.example.accioShop.exception;

import com.example.accioShop.repository.CustomerRepository;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
