package com.example.accioShop.service;

import com.example.accioShop.dto.response.CustomerResponse;
import com.example.accioShop.enums.Gender;
import com.example.accioShop.model.Customer;
import com.example.accioShop.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTests {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void whenCustomerIdExists_thenReturnSavedCustomer() {
        // arrange
        Customer customer = Customer.builder()
                .id(1)
                .name("test-user")
                .age(20)
                .email("test-email@test.com")
                .mobNo("9999999999")
                .gender(Gender.MALE)
                .createdAt(new Date(2025,01,30))
                .build();
        Mockito.when(customerRepository.findById(Mockito.any())).thenReturn(Optional.of(customer));

        // act
        CustomerResponse customerResponse = customerService.getCustomerById(1);

        // assert
        Assertions.assertNotNull(customerResponse);
        Assertions.assertEquals("test-user",customerResponse.getName());
        Assertions.assertEquals("test-email@test.com",customerResponse.getEmail());
        Assertions.assertNotNull(customerResponse.getCreatedAt());
    }
}
