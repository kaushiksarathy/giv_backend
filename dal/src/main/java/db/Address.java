package db;

import lombok.Builder;
import lombok.Getter;
import util.Util;

import java.util.Date;

@Getter
public class Address {
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

    @Builder
    public Address(String city, String country, String lineOne, String lineTwo, String lineThree, String pincode, String state, Date createdAt, Date updatedAt) {
        this.id = Util.randomID(10);
        this.city = city;
        this.country = country;
        this.lineOne = lineOne;
        this.lineTwo = lineTwo;
        this.lineThree = lineThree;
        this.pincode = pincode;
        this.state = state;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
