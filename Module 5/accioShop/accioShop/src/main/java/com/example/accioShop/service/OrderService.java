package com.example.accioShop.service;

import com.example.accioShop.dto.response.OrderResponse;
import com.example.accioShop.enums.OrderStatus;
import com.example.accioShop.exception.CustomerNotFoundException;
import com.example.accioShop.exception.ProductNotFoundException;
import com.example.accioShop.model.Customer;
import com.example.accioShop.model.OrderEntity;
import com.example.accioShop.model.Product;
import com.example.accioShop.repository.CustomerRepository;
import com.example.accioShop.repository.OrderRepository;
import com.example.accioShop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderResponse placeOrder(int customerId,
                                    int productId) {

        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Invalid customer Id: "+customerId);
        }

        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isEmpty()) {
            throw new ProductNotFoundException("Invalid productId: "+productId);
        }

        Customer customer = optionalCustomer.get();
        Product product = productOptional.get();

        OrderEntity order = new OrderEntity();
        order.setValue(product.getPrice());
        order.setStatus(OrderStatus.PLACED);

        order.setCustomer(customer);
        order.getProducts().add(product);

        OrderEntity savedOrder = orderRepository.save(order);

        // response
        return OrderResponse.builder()
                .id(savedOrder.getId())
                .value(savedOrder.getValue())
                .status(savedOrder.getStatus())
                .build();
    }
}
