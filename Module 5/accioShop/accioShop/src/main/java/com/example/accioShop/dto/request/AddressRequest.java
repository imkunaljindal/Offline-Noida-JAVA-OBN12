package com.example.accioShop.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressRequest {

    private String houseNo;

    private String city;

    private String state;

    private int pinCode;
}
