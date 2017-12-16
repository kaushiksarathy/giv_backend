package com.farm.giv.response;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerResponse {
    private String id;
    private String name;
    private String phone;
    private String email;
    private AddressResponse addressResponse;
}
