package dao;

import db.Address;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface AddressDao {
    String TABLE_NAME = "address";

    @SqlUpdate("CREATE TABLE " + TABLE_NAME + " (\n" +
            "  `id` varchar(255) NOT NULL,\n" +
            "  `city` varchar(255) NOT NULL,\n" +
            "  `country` varchar(255) DEFAULT NULL,\n" +
            "  `created_at` datetime DEFAULT NULL,\n" +
            "  `line_one` varchar(255) NOT NULL,\n" +
            "  `line_three` varchar(255) DEFAULT NULL,\n" +
            "  `line_two` varchar(255) DEFAULT NULL,\n" +
            "  `pincode` varchar(255) NOT NULL,\n" +
            "  `state` varchar(255) DEFAULT NULL,\n" +
            "  `updated_at` datetime DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n")
    void createTable();

    @SqlQuery("INSERT INTO " + TABLE_NAME + "" +
            "(id, city, country, line_one, line_two, line_three, pincode, state, created_at, updated_at) " +
            " VALUES (:id, :city, :country, :line_one, :line_two, :line_three, :pincode, :state, :created_at, :updated_at)")
    Address insertBean(@BindBean Address address);

    @SqlQuery("SELECT * FROM " + TABLE_NAME + " WHERE id= :id")
    @RegisterBeanMapper(Address.class)
    Address getAddress(@Bind("id") String id);

    @SqlQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY updated_at desc")
    @RegisterBeanMapper(Address.class)
    List<Address> listAddress();

}
