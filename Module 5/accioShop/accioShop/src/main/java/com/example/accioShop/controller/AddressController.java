package com.example.accioShop.controller;

import com.example.accioShop.dto.request.AddressRequest;
import com.example.accioShop.dto.response.AddressResponse;
import com.example.accioShop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping
    public ResponseEntity addAddress(@RequestParam("customer-id") int customerId,
                                     @RequestBody AddressRequest addressRequest) {
        try {
            AddressResponse response = addressService.addAddress(customerId, addressRequest);
            return new ResponseEntity(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
