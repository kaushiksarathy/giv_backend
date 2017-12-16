package com.farm.giv.adapter;

import com.farm.giv.request.SaleCreateRequest;
import com.farm.giv.response.AddressResponse;
import com.farm.giv.response.CustomerResponse;
import com.farm.giv.response.OrderResponse;
import com.farm.giv.response.SaleResponse;
import db.Sales;
import db.Status;

import java.util.Date;

public class SalesAdapter {
    public static Sales from(SaleCreateRequest request) {
        return Sales.builder()
                .addressId(request.getAddressId())
                .customerId(request.getCustomerId())
                .status(Status.ACTIVE)
                .discount(request.getDiscount())
                .orderId(request.getOrderId())
                .sellingPrice(request.getSellingPrice())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
    }

    public static SaleResponse from(Sales sales, CustomerResponse customerResponse
            , OrderResponse orderResponse
            , AddressResponse addressResponse) {
        return new SaleResponse(sales.getId()
                , customerResponse
                , orderResponse
                , sales.getStatus()
                , addressResponse
                , sales.getDiscount()
                , sales.getSellingPrice()
                , sales.getCreatedAt()
                , sales.getUpdatedAt());
    }
}
