package com.example.accioShop.dto.request;

import com.example.accioShop.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerRequest {

    private String name;

    private int age;

    private String email;

    private Gender gender;

    private String mobNo;
}
