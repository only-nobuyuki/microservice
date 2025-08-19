package com.example.inventory.infrastructure;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * HikariDataSourceの設定と供給
 */
public class DataSourceProvider {
    private static final HikariDataSource ds;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(null);
        config.setUsername(null);
        config.setPassword(null);
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(1);
        config.setAutoCommit(false);
        ds = new HikariDataSource(config);
    }

    private DataSourceProvider() {
    };

    public static DataSource get() {
        return ds;
    }

}