package com.farm.giv.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CustomerCreateRequest {
    private String name;
    private String phone;
    private String email;
    private AddressCreateRequest addressCreateRequest;
}
