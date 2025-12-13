package com.example.zwigato.controller;

import com.example.zwigato.dto.request.MenuItemRequest;
import com.example.zwigato.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/menu")
@RestController
@RequiredArgsConstructor
public class MenuItemController {

    private final MenuService menuService;

    @PostMapping
    public ResponseEntity addMenuItem(@RequestParam int restaurantId,
                                      @RequestBody MenuItemRequest menuItemRequest) {
        try {
            String response = menuService.addMenuItem(restaurantId, menuItemRequest);
            return new ResponseEntity(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
