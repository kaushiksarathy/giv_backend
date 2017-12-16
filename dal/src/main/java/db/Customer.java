package db;

import lombok.Builder;
import lombok.Getter;
import util.Util;


@Getter
public class Customer {
    private String id;
    private String name;
    private String phone;
    private String email;
    private String addressId;

    @Builder
    public Customer(String name, String phone, String email, String addressId){
        this.id = Util.randomID(10);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.addressId = addressId;
    }
}
