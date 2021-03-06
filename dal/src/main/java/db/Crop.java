package db;

import lombok.Builder;
import lombok.Getter;
import util.Util;

import java.util.Date;

@Getter
public class Crop {
    private String id;
    private String code;
    private String name;
    private Status status = Status.ACTIVE;
    private String description;
    private Date createdAt;
    private Date updatedAt;

    @Builder
    public Crop(String code, String name, Status status, String description, Date createdAt, Date updatedAt) {
        this.id = Util.randomID(10);
        this.code = code;
        this.name = name;
        this.status = status;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
