package com.farm.giv.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderCreateRequest {
    private String cropId;
    private Double quantity;
    private String priceId;
}
