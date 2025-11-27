package com.example.accioShop.transformer;

import com.example.accioShop.dto.request.ProductRequest;
import com.example.accioShop.dto.response.ProductResponse;
import com.example.accioShop.model.Product;

import java.util.ArrayList;

public class ProductTransformer {

    public static Product productRequestToProduct(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .category(productRequest.getCategory())
                .reviews(new ArrayList<>())
                .orders(new ArrayList<>())
                .build();
    }

    public static ProductResponse productToProductResponse(Product product) {
        return ProductResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .category(product.getCategory())
                .seller(SellerTransformer.sellerToSellerResponse(product.getSeller()))
                .build();
    }
}
