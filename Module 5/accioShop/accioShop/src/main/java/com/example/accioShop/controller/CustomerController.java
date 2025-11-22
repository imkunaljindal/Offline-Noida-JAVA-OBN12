package com.example.accioShop.controller;

import com.example.accioShop.exception.CustomerNotFoundException;
import com.example.accioShop.model.Customer;
import com.example.accioShop.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@Slf4j
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody Customer customer) {
        log.info("Recieved customer object: {}", customer);
        Customer savedCustomer = customerService.addCustomer(customer);
        return new ResponseEntity(savedCustomer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getCustomerById(@RequestParam("id") int id) {
        try {
            return new ResponseEntity(customerService.getCustomerById(id), HttpStatus.FOUND);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
