package com.example.DailyUpdates.service;

import com.example.DailyUpdates.dto.CustomerRequest;
import com.example.DailyUpdates.dto.CustomerResponse;
import com.example.DailyUpdates.dto.NewsResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {

    RestTemplate restTemplate = new RestTemplate();

    private final String BASE_URL = "https://newsapi.org/v2";
    private final String API_KEY = "19debb000c2946bab25f4d33c83401e3";

    private final String ECOMMERCE_BASE_URL = "http://localhost:9999/api/v1";

    public NewsResponse getNewsByCountry(String countryCode) {
        String url = BASE_URL + "/top-headlines?country="+countryCode+"&apiKey="+API_KEY;
        NewsResponse response = restTemplate.getForObject(url, NewsResponse.class);
        return response;
    }

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        String url = ECOMMERCE_BASE_URL + "/customer";
        //HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<CustomerRequest> httpEntity = new HttpEntity<>(customerRequest);
        return restTemplate.postForObject(url,httpEntity, CustomerResponse.class);
    }
}
