package com.example.accioShop.service;

import com.example.accioShop.dto.request.CustomerRequest;
import com.example.accioShop.dto.response.CustomerResponse;
import com.example.accioShop.exception.CustomerNotFoundException;
import com.example.accioShop.model.Customer;
import com.example.accioShop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        // Step 1 - Request DTO - Entity
        Customer customer = customerRequestToCustomer(customerRequest);
        // Save entity
        Customer savedCustomer = customerRepository.save(customer);
        // Step 3 - Convert saved entity into response
        return customerToCustomerResponse(savedCustomer);
    }

    public CustomerResponse getCustomerById(int id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Invalid id");
        }
        Customer customer = optionalCustomer.get();
        return customerToCustomerResponse(customer);
    }

    public CustomerResponse customerToCustomerResponse(Customer customer) {
       return CustomerResponse.builder()
               .name(customer.getName())
               .createdAt(customer.getCreatedAt())
               .email(customer.getEmail())
               .build();
    }

    public Customer customerRequestToCustomer(CustomerRequest customerRequest) {
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
