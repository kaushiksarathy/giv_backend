package com.farm.giv.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddressCreateRequest {
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
