package com.example.accioShop.transformer;

import com.example.accioShop.dto.request.SellerRequest;
import com.example.accioShop.dto.response.SellerResponse;
import com.example.accioShop.model.Seller;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;

@UtilityClass
public class SellerTransformer {

    public static Seller sellerRequestToSeller(SellerRequest sellerRequest) {
        return Seller.builder()
                .name(sellerRequest.getName())
                .pan(sellerRequest.getPan())
                .email(sellerRequest.getEmail())
                .products(new ArrayList<>())
                .build();
    }

    public static SellerResponse sellerToSellerResponse(Seller seller) {
        return SellerResponse.builder()
                .name(seller.getName())
                .email(seller.getEmail())
                .build();
    }
}
