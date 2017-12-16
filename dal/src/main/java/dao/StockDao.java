package dao;

import db.Stock;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface StockDao {
    String TABLE_NAME = "stock";

    @SqlUpdate("create table " + TABLE_NAME + " (\n" +
            "\tid varchar(255) NOT NULL,\n" +
            "\tcrop_id varchar(255) NOT NULL,\n" +
            "\tout_of_stock bool DEFAULT 1,\n" +
            "\tquantity DECIMAL(5, 2) NOT NULL DEFAULT '0.00',\n" +
            "\t`created_at` datetime DEFAULT CURRENT_TIMESTAMP,\n" +
            "\t`updated_at` datetime DEFAULT CURRENT_TIMESTAMP,\n" +
            "\tprimary key(id),\n" +
            "\tCONSTRAINT `FK_stock_crop_ref` FOREIGN KEY (`crop_id`) REFERENCES `crop` (`id`)\n" +
            ")ENGINE=InnoDB DEFAULT CHARSET=utf8;")
    void createTable();

    @SqlQuery("INSERT INTO " + TABLE_NAME + " (id, crop_id, out_of_stock, quantity, created_at, updated_at) " +
            "VALUES (:id, :crop_id, :out_of_stock, :quantity, createdAt, updatedAt)")
    Stock insertBean(@BindBean Stock stock);

    @SqlQuery("SELECT * FROM " + TABLE_NAME + " WHERE id= :id")
    @RegisterBeanMapper(Stock.class)
    Stock getStock(@Bind("id") String id);

    @SqlQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY updated_at DESC")
    @RegisterBeanMapper(Stock.class)
    List<Stock> listStock();

}
