package com.example.accioShop.transformer;

import com.example.accioShop.dto.request.CustomerRequest;
import com.example.accioShop.dto.response.CustomerResponse;
import com.example.accioShop.model.Customer;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;

@UtilityClass // makes all memebers as static
public class CustomerTransformer {

    public static CustomerResponse customerToCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .name(customer.getName())
                .createdAt(customer.getCreatedAt())
                .email(customer.getEmail())
                .build();
    }

    public static Customer customerRequestToCustomer(CustomerRequest customerRequest) {
//        Customer customer = new Customer();
//        customer.setName(customerRequest.getName());
//        customer.setAge(customerRequest.getAge());
//        customer.setEmail(customerRequest.getEmail());
//        customer.setMobNo(customerRequest.getMobNo());
//        customer.setGender(customerRequest.getGender());
//        return customer;

        return Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .email(customerRequest.getEmail())
                .mobNo(customerRequest.getMobNo())
                .gender(customerRequest.getGender())
                .build();
    }
}
