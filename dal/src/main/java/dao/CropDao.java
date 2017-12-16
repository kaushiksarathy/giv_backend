package dao;

import db.Crop;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface CropDao {
    String TABLE_NAME = "crop";

    @SqlUpdate("create table " + TABLE_NAME + " (\n" +
            "\tid varchar(255) NOT NULL,\n" +
            "\tcode varchar(255) unique key,\n" +
            "\tname varchar(255) NOT NULL,\n" +
            "\t`status` varchar(255) DEFAULT 'ACTIVE',\n" +
            "\tdescription varchar(255) DEFAULT NULL,\n" +
            "\t`created_at` datetime DEFAULT CURRENT_TIMESTAMP,\n" +
            "\t`updated_at` datetime DEFAULT CURRENT_TIMESTAMP," +
            "\tPRIMARY KEY(id)\n" +
            ")ENGINE=InnoDB DEFAULT CHARSET=utf8;")
    void createTable();

    @SqlQuery("INSERT INTO " + TABLE_NAME + " (id, code, name, status, description, created_at, updated_at) " +
            "VALUES (:id, :code, :name, :status, :description, :createdAt, :updatedAt)")
    Crop insertBean(@BindBean Crop crop);

    @SqlQuery("SELECT * FROM " + TABLE_NAME + " WHERE id= :id")
    @RegisterBeanMapper(Crop.class)
    Crop getCrop(@Bind("id") String id);

    @SqlQuery("SELECT * FROM " + TABLE_NAME + " WHERE code= :code")
    @RegisterBeanMapper(Crop.class)
    Crop getCropByCode(@Bind("code") String code);

    @SqlQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY updated_at DESC")
    @RegisterBeanMapper(Crop.class)
    List<Crop> listCrop();

}
