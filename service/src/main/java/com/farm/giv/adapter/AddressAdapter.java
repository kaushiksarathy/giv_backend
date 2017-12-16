package com.farm.giv.adapter;

import com.farm.giv.request.AddressCreateRequest;
import com.farm.giv.response.AddressResponse;
import db.Address;

public class AddressAdapter {
    public static Address from(AddressCreateRequest request) {
        return Address.builder()
                .city(request.getCity())
                .country(request.getCountry())
                .lineOne(request.getLineOne())
                .lineTwo(request.getLineTwo())
                .lineThree(request.getLineThree())
                .pincode(request.getPincode())
                .state(request.getState())
                .build();
    }

    public static AddressResponse from(Address address) {
        return new AddressResponse(address.getId()
                , address.getCity()
                , address.getCountry()
                , address.getCreatedAt()
                , address.getUpdatedAt()
                , address.getLineOne()
                , address.getLineTwo()
                , address.getLineThree()
                , address.getPincode()
                , address.getState());
    }
}
