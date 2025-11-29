package com.example.accioShop.service;

import com.example.accioShop.dto.request.CustomerRequest;
import com.example.accioShop.dto.response.CustomerResponse;
import com.example.accioShop.enums.Gender;
import com.example.accioShop.exception.CustomerNotFoundException;
import com.example.accioShop.model.Customer;
import com.example.accioShop.repository.CustomerRepository;
import com.example.accioShop.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<CustomerResponse> getCustomersByGender(Gender gender) {
//        List<Customer> customers = customerRepository.findAll();
//
//        List<Customer> customersByGender = new ArrayList<>();
//        // filter based on gender
//        for(Customer customer: customers) {
//            if(customer.getGender()==gender) {
//                customersByGender.add(customer);
//            }
//        }

        List<Customer> customersByGender = customerRepository.findByGender(gender);

        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer: customersByGender) {
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }

    public List<CustomerResponse> getCustomersByAgeGreaterThan(int age) {
        List<Customer> customers = customerRepository.findByAgeGreaterThanEqual(age);

        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer: customers) {
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }
}
