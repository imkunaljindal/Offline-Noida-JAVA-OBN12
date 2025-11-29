package com.example.accioShop.transformer;

import com.example.accioShop.dto.request.AddressRequest;
import com.example.accioShop.dto.response.AddressResponse;
import com.example.accioShop.model.Address;

public class AddressTransformer {

    public static Address addressRequestToAddress(AddressRequest addressRequest) {
        return Address.builder()
                .houseNo(addressRequest.getHouseNo())
                .city(addressRequest.getCity())
                .state(addressRequest.getState())
                .pinCode(addressRequest.getPinCode())
                .build();
    }

    public static AddressResponse addressToAddressResponse(Address address) {
        return AddressResponse.builder()
                .houseNo(address.getHouseNo())
                .city(address.getCity())
                .state(address.getState())
                .pinCode(address.getPinCode())
                .customer(CustomerTransformer.customerToCustomerResponse(address.getCustomer()))
                .build();
    }
}
