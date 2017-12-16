package dao;

import db.Sales;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface SalesDao {
    String TABLE_NAME = "sales";

    @SqlUpdate("create table " + TABLE_NAME + " (\n" +
            "\tid varchar(255) NOT NULL,\n" +
            "\tcustomer_id varchar(255) NOT NULL,\n" +
            "\torder_id varchar(255) NOT NULL,\n" +
            "\tstatus varchar(255) DEFAULT 'ACTIVE',\n" +
            "\taddress_id varchar(255) NOT NULL,\n" +
            "\tdiscount DECIMAL(2,2) NOT NULL DEFAULT '0.00',\n" +
            "\tselling_price DECIMAL(10,2) NOT NULL DEFAULT '0.00',\n" +
            "\t`created_at` datetime DEFAULT CURRENT_TIMESTAMP,\n" +
            "\t`updated_at` datetime DEFAULT CURRENT_TIMESTAMP,\n" +
            "\tprimary key (id),\n" +
            "\tCONSTRAINT `FK_sale_cust_ref` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),\n" +
            "\tCONSTRAINT `FK_sale_order_ref` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),\n" +
            "\tCONSTRAINT `FK_sale_address_ref` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)\n" +
            ")ENGINE=InnoDB DEFAULT CHARSET=utf8;\n")
    void createTable();

    @SqlQuery("INSERT INTO " + TABLE_NAME +
            "(id, customer_id, order_id, status, address_id, discount, selling_price, created_at, updated_at) " +
            "VALUES (:id, :customerId, :orderId, :status, :addressId, :discount, sellingPrice, :createdAt, :updatedAt)")
    Sales insertBean(@BindBean Sales sales);

    @SqlQuery("SELECT * FROM " + TABLE_NAME + " WHERE id= :id")
    @RegisterBeanMapper(Sales.class)
    Sales getSales(@Bind("id") String id);

    @SqlQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY updated_at DESC")
    @RegisterBeanMapper(Sales.class)
    List<Sales> listSales();

}
