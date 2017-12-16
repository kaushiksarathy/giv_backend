package com.farm.giv.manager;

import com.farm.giv.adapter.CustomerAdapter;
import com.farm.giv.request.CustomerCreateRequest;
import com.farm.giv.response.AddressResponse;
import com.farm.giv.response.CustomerResponse;
import com.google.inject.Inject;
import dao.CustomerDao;
import db.Customer;

public class CustomerManager {
    private final CustomerDao customerDao;
    private final AddressManager addressManager;

    @Inject
    public CustomerManager(CustomerDao customerDao, AddressManager addressManager) {
        this.customerDao = customerDao;
        this.addressManager = addressManager;
    }

    public CustomerResponse getCustomer(String id) {
        Customer customer = customerDao.getCustomer(id);
        AddressResponse addressResponse = addressManager.getAddress(customer.getAddressId());
        return CustomerAdapter.from(customer, addressResponse);
    }

    public CustomerResponse setCustomer(CustomerCreateRequest request) {
        Customer customer = customerDao.insertBean(CustomerAdapter.from(request));
        AddressResponse addressResponse = addressManager.getAddress(customer.getAddressId());
        return CustomerAdapter.from(customer, addressResponse);
    }
}
