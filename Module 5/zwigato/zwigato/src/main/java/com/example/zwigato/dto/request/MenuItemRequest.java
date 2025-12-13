package com.example.zwigato.dto.request;

import com.example.zwigato.utility.enums.FoodCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MenuItemRequest {

    private String name;

    private int price;

    private FoodCategory category;

    private boolean isVeg;
}
