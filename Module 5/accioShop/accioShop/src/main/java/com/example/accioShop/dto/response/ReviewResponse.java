package com.example.accioShop.dto.response;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ReviewResponse {
    private String comment;
    private int rating;
    ProductResponse product;
}
