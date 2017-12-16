package db;

import lombok.Builder;
import lombok.Getter;
import util.Util;

import java.util.Date;

@Getter
public class Price {
    private String id;
    private String crop_code;
    private Status status = Status.ACTIVE;
    private Double mrp;
    private String unitOfConsumption;
    private Date createdAt;
    private Date updatedAt;

    @Builder
    public Price(String crop_code, Status status, Double mrp, String unitOfConsumption, Date createdAt, Date updatedAt) {
        this.id = Util.randomID(10);
        this.crop_code = crop_code;
        this.status = status;
        this.mrp = mrp;
        this.unitOfConsumption = unitOfConsumption;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
