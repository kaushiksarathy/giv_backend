package com.farm.giv.manager;

import com.google.inject.Inject;
import dao.CustomerDao;
import db.Customer;

public class CustomerManager {
    private final CustomerDao customerDao;

    @Inject
    public CustomerManager(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public Customer getCustomer(String id) {
        System.out.println(id);
        return customerDao.getCustomer(id);
    }
}
