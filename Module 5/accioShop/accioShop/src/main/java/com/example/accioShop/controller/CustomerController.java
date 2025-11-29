package com.example.accioShop.controller;

import com.example.accioShop.dto.request.CustomerRequest;
import com.example.accioShop.dto.response.CustomerResponse;
import com.example.accioShop.enums.Gender;
import com.example.accioShop.exception.CustomerNotFoundException;
import com.example.accioShop.model.Customer;
import com.example.accioShop.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@Slf4j
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest) {
        log.info("Recieved customer object: {}", customerRequest);
        CustomerResponse customerResponse = customerService.addCustomer(customerRequest);
        return new ResponseEntity(customerResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getCustomerById(@RequestParam("id") int id) {
        try {
            CustomerResponse response = customerService.getCustomerById(id);
            return new ResponseEntity(response, HttpStatus.FOUND);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // filter based on gender
    // input - gender
    // output - List<CustomerResponse>

    @GetMapping("/gender/{gender}")
    public ResponseEntity getCustomerByGender(@PathVariable Gender gender) {
        List<CustomerResponse> responses = customerService.getCustomersByGender(gender);
        return new ResponseEntity(responses,HttpStatus.OK);
    }

    // input - age
    // List<CustomerResponse> where age >= input age

    @GetMapping("/age")
    public ResponseEntity getCustomersByAgeGreaterThan(@RequestParam("age") int age) {
        List<CustomerResponse> responses = customerService.getCustomersByAgeGreaterThan(age);
        return new ResponseEntity(responses,HttpStatus.OK);
    }
}
