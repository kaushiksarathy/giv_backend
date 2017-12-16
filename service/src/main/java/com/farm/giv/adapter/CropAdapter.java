package com.farm.giv.adapter;

import com.farm.giv.request.CropCreateRequest;
import com.farm.giv.response.CropResponse;
import db.Crop;
import db.Status;

import java.util.Date;

public class CropAdapter {
    public static Crop from(CropCreateRequest request) {
        return Crop.builder()
                .code(request.getCode())
                .name(request.getName())
                .status(Status.ACTIVE)
                .description(request.getDescription())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
    }

    public static CropResponse from(Crop crop) {
        return new CropResponse(crop.getId()
                , crop.getCode()
                , crop.getName()
                , crop.getStatus()
                , crop.getDescription()
                , crop.getCreatedAt()
                , crop.getUpdatedAt());
    }
}
