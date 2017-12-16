package com.farm.giv.adapter;

import com.farm.giv.request.OrderCreateRequest;
import com.farm.giv.response.CropResponse;
import com.farm.giv.response.OrderResponse;
import com.farm.giv.response.PriceResponse;
import db.Order;
import db.Status;

import java.util.Date;

public class OrderAdapter {
    public static Order from(OrderCreateRequest request) {
        return Order.builder()
                .cropId(request.getCropId())
                .priceId(request.getPriceId())
                .quantity(request.getQuantity())
                .status(Status.ACTIVE)
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
    }

    public static OrderResponse from(Order order, CropResponse cropResponse, PriceResponse priceResponse) {
        return new OrderResponse(order.getId()
                , cropResponse
                , order.getQuantity()
                , priceResponse
                , order.getStatus()
                , order.getCreatedAt()
                , order.getUpdatedAt());
    }
}
