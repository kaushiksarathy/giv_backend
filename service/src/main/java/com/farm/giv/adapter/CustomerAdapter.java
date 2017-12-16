package com.farm.giv.adapter;

import com.farm.giv.request.CustomerCreateRequest;
import com.farm.giv.response.AddressResponse;
import com.farm.giv.response.CustomerResponse;
import db.Address;
import db.Customer;

public class CustomerAdapter {
    public static Customer from(CustomerCreateRequest customerCreateRequest) {
        Address address = AddressAdapter.from(customerCreateRequest.getAddressCreateRequest());
        return Customer.builder()
                .name(customerCreateRequest.getName())
                .email(customerCreateRequest.getEmail())
                .phone(customerCreateRequest.getPhone())
                .addressId(address.getId())
                .build();
    }

    public static CustomerResponse from(Customer customer, AddressResponse addressResponse) {
        return new CustomerResponse(customer.getId(), customer.getName(), customer.getPhone(), customer.getEmail(), addressResponse);
    }
}
