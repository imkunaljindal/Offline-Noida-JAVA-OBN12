package com.example.accioShop.dto.response;

import com.example.accioShop.enums.OrderStatus;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderResponse {

    private String id;

    private int value;

    private OrderStatus status;
}
