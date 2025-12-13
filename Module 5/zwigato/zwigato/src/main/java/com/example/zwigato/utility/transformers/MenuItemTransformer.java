package com.example.zwigato.utility.transformers;

import com.example.zwigato.dto.request.MenuItemRequest;
import com.example.zwigato.dto.response.MenuItemResponse;
import com.example.zwigato.model.MenuItem;

import java.util.ArrayList;

public class MenuItemTransformer {

    public static MenuItem menuItemRequestToMenuItem(MenuItemRequest menuItemRequest) {
        return MenuItem.builder()
                .name(menuItemRequest.getName())
                .price(menuItemRequest.getPrice())
                .category(menuItemRequest.getCategory())
                .isVeg(menuItemRequest.isVeg())
                .restaurants(new ArrayList<>())
                .build();
    }

    public static MenuItemResponse menuItemToMenuItemResponse(MenuItem menuItem) {
        return MenuItemResponse.builder()
                .name(menuItem.getName())
                .price(menuItem.getPrice())
                .category(menuItem.getCategory())
                .isVeg(menuItem.isVeg())
                .build();
    }
}
