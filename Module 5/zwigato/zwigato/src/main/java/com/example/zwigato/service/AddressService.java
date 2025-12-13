package com.example.zwigato.service;

import com.example.zwigato.dao.CustomerRepository;
import com.example.zwigato.dto.request.AddressRequest;
import com.example.zwigato.dto.response.AddressResponse;
import com.example.zwigato.exceptions.CustomerNotFoundException;
import com.example.zwigato.model.Address;
import com.example.zwigato.model.Customer;
import com.example.zwigato.utility.transformers.AddressTransformer;
import com.example.zwigato.utility.transformers.CustomerTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final CustomerRepository customerRepository;

    public AddressResponse addAddress(int customerId,
                                      AddressRequest addressRequest) {
        Optional<Customer> customerOptional =  customerRepository.findById(customerId);
        if(customerOptional.isEmpty()) {
            throw new CustomerNotFoundException("Invalid customer Id: "+customerId);
        }

        Customer customer = customerOptional.get();
        Address address = AddressTransformer.addressRequestToAddress(addressRequest);

        customer.getAddress().add(address);

        Customer savedCustomer = customerRepository.save(customer); // customer + address;

        int sz = savedCustomer.getAddress().size();
        Address lastSavedAddress = savedCustomer.getAddress().get(sz-1);

        AddressResponse response = AddressTransformer.addressTOAddressResponse(lastSavedAddress);
        response.setCustomer(CustomerTransformer.customerToCustomerResponse(savedCustomer));

        return response;
    }
}
