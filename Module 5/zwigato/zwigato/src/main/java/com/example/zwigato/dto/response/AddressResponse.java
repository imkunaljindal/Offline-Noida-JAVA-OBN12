package com.example.zwigato.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AddressResponse {

    private String houseNo;

    private String city;

    private String state;

    private int pinCode;

    private CustomerResponse customer;
}
