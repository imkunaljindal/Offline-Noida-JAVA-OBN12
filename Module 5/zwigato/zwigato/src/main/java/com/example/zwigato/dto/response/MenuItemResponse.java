package com.example.zwigato.dto.response;

import com.example.zwigato.utility.enums.FoodCategory;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MenuItemResponse {

    private String name;

    private int price;

    private FoodCategory category;

    private boolean isVeg;
}
