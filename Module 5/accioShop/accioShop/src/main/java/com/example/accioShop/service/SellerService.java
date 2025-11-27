package com.example.accioShop.service;

import com.example.accioShop.dto.request.SellerRequest;
import com.example.accioShop.dto.response.SellerResponse;
import com.example.accioShop.model.Seller;
import com.example.accioShop.repository.SellerRepository;
import com.example.accioShop.transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public SellerResponse addSeller(SellerRequest sellerRequest) {
        Seller seller = SellerTransformer.sellerRequestToSeller(sellerRequest);
        Seller savedSeller = sellerRepository.save(seller);
        return SellerTransformer.sellerToSellerResponse(savedSeller);
    }
}
