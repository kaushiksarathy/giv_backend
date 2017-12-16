package com.farm.giv.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SaleCreateRequest {
    private String customerId;
    private String orderId;
    private String addressId;
    private Double discount;
    private Double sellingPrice;

}
