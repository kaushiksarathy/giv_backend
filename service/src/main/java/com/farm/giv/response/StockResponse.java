package com.farm.giv.response;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class StockResponse {
    private String id;
    private CropResponse cropResponse;
    private boolean outOfStock;
    private Double quantity;
    private Date createdAt;
    private Date updatedAt;
}
