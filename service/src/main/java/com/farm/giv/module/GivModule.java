package com.farm.giv.module;

import com.farm.giv.config.DatabaseConfig;
import com.farm.giv.config.GivConfig;
import com.google.inject.*;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import dao.CustomerDao;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import javax.sql.DataSource;

public class GivModule implements Module {
    public void configure(Binder binder) {
    }

    @Provides
    @Singleton
    public Jdbi getDbi(GivConfig givConfig){
        return Jdbi.create(getDataSource(givConfig.getDatabaseConfig()));
    }

    @Inject
    @Provides
    @Singleton
    public CustomerDao getCustomerDao(Jdbi jdbi){
        jdbi.installPlugin(new SqlObjectPlugin());
        return jdbi.onDemand(CustomerDao.class);
    }

    private DataSource getDataSource(DatabaseConfig databaseConfig) {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(databaseConfig.getDriverClass());
        config.setJdbcUrl(databaseConfig.getUrl());
        config.setUsername(databaseConfig.getUser());
        config.setPassword(databaseConfig.getPassword());
        config.setConnectionTestQuery(databaseConfig.getValidationQuery());
        config.setValidationTimeout(databaseConfig.getValidationQueryTimeout());
        config.setConnectionTimeout(databaseConfig.getMaxWaitForConnection());
        config.setMinimumIdle(databaseConfig.getMinSize());
        config.setMaximumPoolSize(databaseConfig.getMaxSize());
        config.setIdleTimeout(databaseConfig.getMinIdleTime());

        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        return new HikariDataSource(config);
    }
}
