package com.example.accioShop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AddressResponse {

    private String houseNo;

    private String city;

    private String state;

    private int pinCode;

    private CustomerResponse customer;
}
