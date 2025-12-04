package com.example.DailyUpdates.controller;

import com.example.DailyUpdates.dto.CustomerRequest;
import com.example.DailyUpdates.dto.CustomerResponse;
import com.example.DailyUpdates.dto.NewsResponse;
import com.example.DailyUpdates.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/news")
public class NewController {

    @Autowired
    NewsService newsService;

    @GetMapping
    public ResponseEntity getNewsByCountry(@RequestParam(value = "country",
            required = false,
            defaultValue = "in") String countryCode) {
        NewsResponse response = newsService.getNewsByCountry(countryCode);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest) {
        CustomerResponse customerResponse = newsService.addCustomer(customerRequest);
        return new ResponseEntity(customerResponse,HttpStatus.CREATED);
    }
}
