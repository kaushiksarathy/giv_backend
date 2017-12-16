package com.farm.giv.manager;

import com.farm.giv.adapter.AddressAdapter;
import com.farm.giv.request.AddressCreateRequest;
import com.farm.giv.response.AddressResponse;
import com.google.inject.Inject;
import dao.AddressDao;
import db.Address;

public class AddressManager {
    private final AddressDao addressDao;

    @Inject
    public AddressManager(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public AddressResponse getAddress(String id) {
        Address address = addressDao.getAddress(id);
        return AddressAdapter.from(address);
    }

    public AddressResponse setAddress(AddressCreateRequest request) {
        Address address = addressDao.insertBean(AddressAdapter.from(request));
        return AddressAdapter.from(address);
    }
}
