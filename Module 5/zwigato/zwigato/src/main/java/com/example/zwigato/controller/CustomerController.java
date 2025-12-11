package com.example.zwigato.controller;

import com.example.zwigato.dto.request.CustomerRequest;
import com.example.zwigato.dto.response.CustomerResponse;
import com.example.zwigato.service.CustomerService;
import com.example.zwigato.utility.enums.Gender;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest) {
        CustomerResponse response = customerService.addCustomer(customerRequest);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/gender/{gender}")
    public ResponseEntity getByGender(@PathVariable Gender gender) {
        List<CustomerResponse> response = customerService.getByGender(gender);
        return new ResponseEntity(response,HttpStatus.OK);
    }
}
