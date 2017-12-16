package dao;

import db.Price;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface PriceDao {
    String TABLE_NAME = "price";

    @SqlUpdate("create table " + TABLE_NAME + " (\n" +
            "\tid varchar(255) NOT NULL,\n" +
            "\tcrop_code varchar(255) NOT NULL,\n" +
            "\t`status` varchar(255) DEFAULT 'ACTIVE',\n" +
            "\tmrp DECIMAL(10, 2) NOT NULL DEFAULT '0.00',\n" +
            "\tunit_of_consumption varchar(255) DEFAULT 'kg', \n" +
            "\t`created_at` datetime DEFAULT CURRENT_TIMESTAMP,\n" +
            "\t`updated_at` datetime DEFAULT CURRENT_TIMESTAMP,\n" +
            "\tprimary key(id),\n" +
            "\tCONSTRAINT `FK_price_crop_ref` FOREIGN KEY (`crop_code`) REFERENCES `crop` (`code`)\n" +
            ")ENGINE=InnoDB DEFAULT CHARSET=utf8;\n")
    void createTable();

    @SqlQuery("INSERT INTO " + TABLE_NAME + " (id, crop_code, status, mrp, unit_of_consumption, created_at, updated_at) " +
            "VALUES (:id, :cropCode, :status, :mrp, :unitOfConsumption, createdAt, updatedAt)")
    Price insertBean(@BindBean Price price);

    @SqlQuery("SELECT * FROM " + TABLE_NAME + " WHERE id= :id")
    @RegisterBeanMapper(Price.class)
    Price getPrice(@Bind("id") String id);

    @SqlQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY updated_at DESC")
    @RegisterBeanMapper(Price.class)
    List<Price> listPrice();

}
