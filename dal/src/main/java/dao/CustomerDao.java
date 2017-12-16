package dao;

import db.Customer;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface CustomerDao {
    String TABLE_NAME = "customer";

    @SqlUpdate("create table if not exists " + TABLE_NAME + " (\n" +
            "\tid varchar(255) NOT NULL,\n" +
            "\tname varchar(255) NOT NULL,\n" +
            "\tphone varchar(255) NOT NULL,\n" +
            "\temail varchar(255) DEFAULT NULL,\n" +
            "\taddress_id varchar(255) DEFAULT NULL,\n" +
            "\tprimary key (id),\n" +
            "\tCONSTRAINT `FK_customer_address_ref` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)\n" +
            ")ENGINE=InnoDB DEFAULT CHARSET=utf8;")
    void createTable();

    @SqlQuery("INSERT INTO " + TABLE_NAME + " (id, name, phone, email, address_id) VALUES (:id, :name, :phone, :email, :addressId)")
    Customer insertBean(@BindBean Customer customer);

    @SqlQuery("SELECT * FROM " + TABLE_NAME + " WHERE id= :id")
    @RegisterBeanMapper(Customer.class)
    Customer getCustomer(@Bind("id") String id);

    @SqlQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY updated_at DESC")
    @RegisterBeanMapper(Customer.class)
    List<Customer> listCustomer();
}
