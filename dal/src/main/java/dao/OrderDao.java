package dao;

import db.Order;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface OrderDao {
    String TABLE_NAME = "order";
    @SqlUpdate("create table "+TABLE_NAME+" (\n" +
            "\tid varchar(255) NOT NULL,\n" +
            "\tcrop_id varchar(255) NOT NULL,\n" +
            "\tquantity DECIMAL(5, 2) NOT NULL DEFAULT '0.00',\n" +
            "\tprice_id varchar(255) NOT NULL,\n" +
            "\t`status` varchar(255) DEFAULT 'ACTIVE',\n" +
            "\t`created_at` datetime DEFAULT CURRENT_TIMESTAMP,\n" +
            "\t`updated_at` datetime DEFAULT CURRENT_TIMESTAMP,\n"+
            "\tprimary key(id),\n" +
            "\tCONSTRAINT `FK_order_crop_ref` FOREIGN KEY (`crop_id`) REFERENCES `crop` (`id`),\n" +
            "\tCONSTRAINT `FK_order_price_ref` FOREIGN KEY (`price_id`) REFERENCES `price` (`id`)\n" +
            ")ENGINE=InnoDB DEFAULT CHARSET=utf8;")
    void createTable();

    @SqlQuery("INSERT INTO " + TABLE_NAME + " (id, crop_id, quantity, price_id, status, created_at, updated_at) " +
            "VALUES (:id, :cropId, :quantity, price_id, :status, :createdAt, :updatedAt)")
    Order insertBean(@BindBean Order order);

    @SqlQuery("SELECT * FROM " + TABLE_NAME + " WHERE id= :id")
    @RegisterBeanMapper(Order.class)
    Order getOrder(@Bind("id") String id);

    @SqlQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY updated_at DESC")
    @RegisterBeanMapper(Order.class)
    List<Order> listOrder();
}
