package com.farm.giv.adapter;

import com.farm.giv.request.PriceCreateRequest;
import com.farm.giv.response.CropResponse;
import com.farm.giv.response.PriceResponse;
import db.Price;
import db.Status;

import java.util.Date;

public class PriceAdapter {
    public static Price from(PriceCreateRequest request) {
        return Price.builder()
                .crop_code(request.getCrop_code())
                .mrp(request.getMrp())
                .status(Status.ACTIVE)
                .unitOfConsumption(request.getUnitOfConsumption())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
    }

    public static PriceResponse from(Price price, CropResponse cropResponse) {
        return new PriceResponse(price.getId()
                , cropResponse
                , price.getStatus()
                , price.getMrp()
                , price.getUnitOfConsumption()
                , price.getCreatedAt()
                , price.getUpdatedAt());
    }
}
