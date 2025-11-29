package com.example.accioShop.service;

import com.example.accioShop.dto.request.AddressRequest;
import com.example.accioShop.dto.response.AddressResponse;
import com.example.accioShop.exception.CustomerNotFoundException;
import com.example.accioShop.model.Address;
import com.example.accioShop.model.Customer;
import com.example.accioShop.repository.AddressRepository;
import com.example.accioShop.repository.CustomerRepository;
import com.example.accioShop.transformer.AddressTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AddressRepository addressRepository;

    public AddressResponse addAddress(int customerId,
                                      AddressRequest addressRequest) {

        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if(customerOptional.isEmpty()) {
            throw new CustomerNotFoundException("Invalid customer id: "+customerId);
        }

        Customer customer = customerOptional.get();
        Address address = AddressTransformer.addressRequestToAddress(addressRequest);

        // relationship -> foreign key
        address.setCustomer(customer);

        // save address
        Address savedAddress = addressRepository.save(address); // address + customer

        // response
        return AddressTransformer.addressToAddressResponse(savedAddress);


    }
}
