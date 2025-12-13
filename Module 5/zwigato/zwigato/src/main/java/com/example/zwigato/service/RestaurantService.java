package com.example.zwigato.service;

import com.example.zwigato.dao.RestaurantRepository;
import com.example.zwigato.dto.response.MenuItemResponse;
import com.example.zwigato.dto.response.RestaurantResponse;
import com.example.zwigato.exceptions.RestaurantNotFoundException;
import com.example.zwigato.model.MenuItem;
import com.example.zwigato.model.Restaurant;
import com.example.zwigato.utility.transformers.MenuItemTransformer;
import com.example.zwigato.utility.transformers.RestaurantTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<MenuItemResponse> getAllMenuItems(int restaurantId) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        if(restaurantOptional.isEmpty()) {
            throw new RestaurantNotFoundException("Invalid restaurant Id: "+restaurantId);
        }

        Restaurant restaurant = restaurantOptional.get();
        List<MenuItem> menuItems = restaurant.getMenuItems();

        // convert into list of menu items response
        List<MenuItemResponse> menuItemResponses = new ArrayList<>();
        for(MenuItem menuItem: menuItems) {
            menuItemResponses.add(MenuItemTransformer.menuItemToMenuItemResponse(menuItem));
        }

        return menuItemResponses;

    }
}
