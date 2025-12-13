package com.example.zwigato.controller;

import com.example.zwigato.dto.response.MenuItemResponse;
import com.example.zwigato.service.RestaurantService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // API to get all the menu items of a restaurant
    /**
     * @Param - restaurantId
     */
    @GetMapping
    public ResponseEntity getAllMenuItems(@RequestParam int restaurantId) {
        List<MenuItemResponse> menuItems = restaurantService.getAllMenuItems(restaurantId);
        return new ResponseEntity(menuItems,HttpStatus.OK);
    }
}
