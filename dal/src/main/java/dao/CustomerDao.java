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
    @SqlUpdate("CREATE TABLE user (id INTEGER PRIMARY KEY, name VARCHAR)")
    void createTable();

    @SqlUpdate("INSERT INTO user(id, name) VALUES (:id, :name)")
    void insertBean(@BindBean Customer customer);

    @SqlQuery("SELECT * FROM "+TABLE_NAME+" WHERE id= :id")
    @RegisterBeanMapper(Customer.class)
    Customer getCustomer(@Bind("id") String id);

    @SqlQuery("SELECT * FROM user ORDER BY name")
    @RegisterBeanMapper(Customer.class)
    List<Customer> listCustomer();
}
