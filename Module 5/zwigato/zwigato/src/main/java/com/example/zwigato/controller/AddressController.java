package com.example.zwigato.controller;

import com.example.zwigato.dto.request.AddressRequest;
import com.example.zwigato.dto.response.AddressResponse;
import com.example.zwigato.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

//    public AddressController(AddressService addressService) {
//        this.addressService = addressService;
//    }

    @PostMapping
    public ResponseEntity addAddress(@RequestParam int customerId,
                                     @RequestBody AddressRequest addressRequest) {
        try {
            AddressResponse response = addressService.addAddress(customerId, addressRequest);
            return new ResponseEntity(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
