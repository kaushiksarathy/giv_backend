package com.farm.giv.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PriceCreateRequest {
    private String crop_code;
    private Double mrp;
    private String unitOfConsumption;
}
