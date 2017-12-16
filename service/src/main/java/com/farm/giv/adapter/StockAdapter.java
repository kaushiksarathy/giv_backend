package com.farm.giv.adapter;

import com.farm.giv.request.StockCreateRequest;
import com.farm.giv.response.CropResponse;
import com.farm.giv.response.StockResponse;
import db.Stock;

import java.util.Date;

public class StockAdapter {
    public static Stock from(StockCreateRequest request) {
        return Stock.builder()
                .cropId(request.getCropId())
                .outOfStock(true)
                .quantity(request.getQuantity())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
    }

    public static StockResponse from(Stock stock, CropResponse cropResponse) {
        return new StockResponse(stock.getId()
                , cropResponse
                , stock.isOutOfStock()
                , stock.getQuantity()
                , stock.getCreatedAt()
                , stock.getUpdatedAt());
    }
}
