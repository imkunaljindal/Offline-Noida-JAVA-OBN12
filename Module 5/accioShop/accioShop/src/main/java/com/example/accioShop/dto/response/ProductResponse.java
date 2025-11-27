package com.example.accioShop.dto.response;

import com.example.accioShop.enums.Category;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductResponse {

    private String name;

    private int price;

    private Category category;

    private SellerResponse seller;
}
