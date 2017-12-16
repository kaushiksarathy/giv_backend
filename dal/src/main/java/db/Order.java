package db;

import lombok.Builder;
import lombok.Getter;
import util.Util;

import java.util.Date;

@Getter
public class Order {
    private String id;
    private String cropId;
    private Double quantity;
    private String priceId;
    private Status status = Status.ACTIVE;
    private Date createdAt;
    private Date updatedAt;

    @Builder
    public Order(String cropId, Double quantity, String priceId, Status status, Date createdAt, Date updatedAt) {
        this.id = Util.randomID(10);
        this.cropId = cropId;
        this.quantity = quantity;
        this.priceId = priceId;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
