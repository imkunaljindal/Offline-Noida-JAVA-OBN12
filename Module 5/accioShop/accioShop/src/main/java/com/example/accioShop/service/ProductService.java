package com.example.accioShop.service;

import com.example.accioShop.dto.request.ProductRequest;
import com.example.accioShop.dto.response.ProductResponse;
import com.example.accioShop.exception.SellerNotFoundException;
import com.example.accioShop.model.Product;
import com.example.accioShop.model.Seller;
import com.example.accioShop.repository.ProductRepository;
import com.example.accioShop.repository.SellerRepository;
import com.example.accioShop.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;

    public ProductResponse addProduct(int sellerId,
                                      ProductRequest productRequest) {
        Optional<Seller> sellerOptional = sellerRepository.findById(sellerId);
        if(sellerOptional.isEmpty()) {
            throw new SellerNotFoundException("Invalid seller Id");
        }

        // 1. DTO -> Entity
        Product product = ProductTransformer.productRequestToProduct(productRequest);

        // set the relationship
        Seller seller = sellerOptional.get();
        seller.getProducts().add(product);
        product.setSeller(seller);

        Seller savedSeller = sellerRepository.save(seller); //seller + product

        // productresponse
        int size = savedSeller.getProducts().size();
        Product savedProduct = savedSeller.getProducts().get(size-1);
        return ProductTransformer.productToProductResponse(savedProduct);

    }
}
