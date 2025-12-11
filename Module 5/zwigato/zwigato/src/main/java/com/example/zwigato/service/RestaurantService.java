package com.example.zwigato.service;

import com.example.zwigato.dao.RestaurantRepository;
import com.example.zwigato.dto.response.RestaurantResponse;
import com.example.zwigato.model.Restaurant;
import com.example.zwigato.utility.transformers.RestaurantTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantResponse addRestaurant(String name, String location) {
        Restaurant restaurant = Restaurant.builder()
                .name(name)
                .location(location)
                .isOpen(true)
                .menuItems(new ArrayList<>())
                .build();

        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return RestaurantTransformer.restaurantToRestauranResponse(savedRestaurant);
    }
}
