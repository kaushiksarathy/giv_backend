package com.farm.giv.response;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class AddressResponse {
    private String id;
    private String city;
    private String country;
    private Date createdAt;
    private Date updatedAt;
    private String lineOne;
    private String lineTwo;
    private String lineThree;
    private String pincode;
    private String state;
}
