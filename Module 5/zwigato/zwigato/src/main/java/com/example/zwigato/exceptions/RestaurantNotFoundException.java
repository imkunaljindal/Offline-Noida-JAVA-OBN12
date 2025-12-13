package com.example.zwigato.exceptions;

public class RestaurantNotFoundException extends RuntimeException{
    public RestaurantNotFoundException(String message) {
        super(message);
    }
}
