package com.farm.giv.response;

import db.Status;
import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class PriceResponse {
    private String id;
    private CropResponse cropResponse;
    private Status status;
    private Double mrp;
    private String unitOfConsumption;
    private Date createdAt;
    private Date updatedAt;
}
