package db;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class Stock {
    private String id;
    private String cropId;
    private boolean outOfStock;
    private Double quantity;
    private Date createdAt;
    private Date updatedAt;

    @Builder
    public Stock(String cropId, boolean outOfStock, Double quantity, Date createdAt, Date updatedAt) {
        this.cropId = cropId;
        this.outOfStock = outOfStock;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
