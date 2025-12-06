package com.example.accioShop.repository;

import com.example.accioShop.enums.Gender;
import com.example.accioShop.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class CustomerRepositoryTests {

    @Autowired CustomerRepository customerRepository;

    @Test
    void shouldSucceed_whenValidCustomerIsSaved() {
        // arrange
        Customer customer = Customer.builder()
                .name("test")
                .age(52)
                .gender(Gender.MALE)
                .email("bdisakldkn@gmail.com")
                .mobNo("000000000")
                .build();

        //act
        Customer savedCustomer = customerRepository.save(customer);

        // assert
        Assertions.assertEquals("test",savedCustomer.getName());
        Assertions.assertNotEquals(0,savedCustomer.getId());
        Assertions.assertNotNull(savedCustomer.getCreatedAt());
    }
}
