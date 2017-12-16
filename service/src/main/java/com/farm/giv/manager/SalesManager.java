package com.farm.giv.manager;

import com.farm.giv.adapter.SalesAdapter;
import com.farm.giv.request.SaleCreateRequest;
import com.farm.giv.response.AddressResponse;
import com.farm.giv.response.CustomerResponse;
import com.farm.giv.response.OrderResponse;
import com.farm.giv.response.SaleResponse;
import com.google.inject.Inject;
import dao.SalesDao;
import db.Sales;

public class SalesManager {
    private final SalesDao salesDao;
    private final CustomerManager customerManager;
    private final OrderManager orderManager;
    private final AddressManager addressManager;

    @Inject
    public SalesManager(SalesDao salesDao, CustomerManager customerManager, OrderManager orderManager, AddressManager addressManager) {
        this.salesDao = salesDao;
        this.customerManager = customerManager;
        this.orderManager = orderManager;
        this.addressManager = addressManager;
    }

    public SaleResponse getSales(String id) {
        Sales sales = salesDao.getSales(id);
        CustomerResponse customerResponse = customerManager.getCustomer(sales.getCustomerId());
        OrderResponse orderResponse = orderManager.getOrder(sales.getOrderId());
        AddressResponse addressResponse = addressManager.getAddress(sales.getAddressId());
        return SalesAdapter.from(sales, customerResponse, orderResponse, addressResponse);
    }

    public SaleResponse setSales(SaleCreateRequest request) {
        Sales sales = salesDao.insertBean(SalesAdapter.from(request));
        CustomerResponse customerResponse = customerManager.getCustomer(sales.getCustomerId());
        OrderResponse orderResponse = orderManager.getOrder(sales.getOrderId());
        AddressResponse addressResponse = addressManager.getAddress(sales.getAddressId());
        return SalesAdapter.from(sales, customerResponse, orderResponse, addressResponse);
    }
}
