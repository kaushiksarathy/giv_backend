package db;

import lombok.Builder;
import lombok.Getter;
import util.Util;

import java.util.Date;

@Getter
public class Sales {
    private String id;
    private String customerId;
    private String orderId;
    private Status status = Status.ACTIVE;
    private String addressId;
    private Double discount;
    private Double sellingPrice;
    private Date createdAt;
    private Date updatedAt;

    @Builder
    public Sales(String customerId, String orderId, Status status, String addressId, Double discount, Double sellingPrice, Date createdAt, Date updatedAt) {
        this.id = Util.randomID(10);
        this.customerId = customerId;
        this.orderId = orderId;
        this.status = status;
        this.addressId = addressId;
        this.discount = discount;
        this.sellingPrice = sellingPrice;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
