package com.farm.giv.response;

import db.Status;
import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class SaleResponse {
    private String id;
    private CustomerResponse customerResponse;
    private OrderResponse orderResponse;
    private Status status;
    private AddressResponse addressResponse;
    private Double discount;
    private Double sellingPrice;
    private Date createdAt;
    private Date updatedAt;
}
