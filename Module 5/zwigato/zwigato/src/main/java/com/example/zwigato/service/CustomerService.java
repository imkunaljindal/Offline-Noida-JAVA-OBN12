package com.example.zwigato.service;

import com.example.zwigato.dao.CustomerRepository;
import com.example.zwigato.dto.request.CustomerRequest;
import com.example.zwigato.dto.response.CustomerResponse;
import com.example.zwigato.model.Customer;
import com.example.zwigato.utility.enums.Gender;
import com.example.zwigato.utility.transformers.CustomerTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }

    public List<CustomerResponse> getByGender(Gender gender) {
        List<Customer> customers = customerRepository.findByGender(gender);
        List<CustomerResponse> response = new ArrayList<>();

        for(Customer customer: customers) {
            response.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return response;
    }
}
