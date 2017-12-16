package com.farm.giv.response;

import db.Status;
import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class CropResponse {
    private String id;
    private String code;
    private String name;
    private Status status;
    private String description;
    private Date createdAt;
    private Date updatedAt;
}
