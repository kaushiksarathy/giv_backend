package com.farm.giv.response;

import db.Status;
import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class OrderResponse {
    private String id;
    private CropResponse cropResponse;
    private Double quantity;
    private PriceResponse priceResponse;
    private Status status;
    private Date createdAt;
    private Date updatedAt;
}
