package com.example.zwigato.controller;

import com.example.zwigato.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity addRestaurant(@RequestParam String name,
                                        @RequestParam String location) {
        return new ResponseEntity(restaurantService.addRestaurant(name,location),
                HttpStatus.CREATED);
    }

    // API to change the is_open status
}
