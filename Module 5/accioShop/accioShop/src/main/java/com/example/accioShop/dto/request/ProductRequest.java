package com.example.accioShop.dto.request;

import com.example.accioShop.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductRequest {

    private String name;

    private int price;

    private Category category;
}
