package com.example.zwigato.service;

import com.example.zwigato.dao.RestaurantRepository;
import com.example.zwigato.dto.request.MenuItemRequest;
import com.example.zwigato.exceptions.RestaurantNotFoundException;
import com.example.zwigato.model.MenuItem;
import com.example.zwigato.model.Restaurant;
import com.example.zwigato.utility.transformers.MenuItemTransformer;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final RestaurantRepository restaurantRepository;

    public String addMenuItem(int restaurantId,
                              MenuItemRequest menuItemRequest) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        if(restaurantOptional.isEmpty()) {
            throw new RestaurantNotFoundException("Invalid restaurant id: "+ restaurantId);
        }

        Restaurant restaurant = restaurantOptional.get();
        MenuItem menuItem = MenuItemTransformer.menuItemRequestToMenuItem(menuItemRequest);
        menuItem.getRestaurants().add(restaurant);

        restaurant.getMenuItems().add(menuItem);
        restaurantRepository.save(restaurant); // restaurant + menu item

        return "Menu Item added successfully";
    }
}
