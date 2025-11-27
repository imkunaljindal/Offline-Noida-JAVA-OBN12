package com.example.accioShop.service;

import com.example.accioShop.dto.request.CustomerRequest;
import com.example.accioShop.dto.response.CustomerResponse;
import com.example.accioShop.exception.CustomerNotFoundException;
import com.example.accioShop.model.Customer;
import com.example.accioShop.repository.CustomerRepository;
import com.example.accioShop.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        // Step 1 - Request DTO - Entity
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        // Save entity
        Customer savedCustomer = customerRepository.save(customer);
        // Step 3 - Convert saved entity into response
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }

    public CustomerResponse getCustomerById(int id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Invalid id");
        }
        Customer customer = optionalCustomer.get();
        return CustomerTransformer.customerToCustomerResponse(customer);
    }
}
