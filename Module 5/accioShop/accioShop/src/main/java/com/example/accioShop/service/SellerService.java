package com.example.accioShop.service;

import com.example.accioShop.model.Seller;
import com.example.accioShop.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public Seller addSeller(Seller seller) {
        return sellerRepository.save(seller);
    }
}
