package org.example.ch5;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String DB_URL = "jdbc:h2:mem://localhost/~/jdbc-practice;MODE=MySQL;DB_CLOSE_DELAY=1";
    private static final String DRIVER_CLASS_NAME = "org.h2.Driver";
    private static final String ID = "sa";
    private static final String PASSWORD = "";
    public static final int MAX_POOL_SIZE = 20;

    private static final DataSource dataSource;

    static {
        HikariDataSource hikariDataSource = new HikariDataSource();

        hikariDataSource.setDriverClassName(DRIVER_CLASS_NAME);
        hikariDataSource.setJdbcUrl(DB_URL);
        hikariDataSource.setUsername(ID);
        hikariDataSource.setPassword(PASSWORD);

        hikariDataSource.setMaximumPoolSize(MAX_POOL_SIZE);
        hikariDataSource.setMinimumIdle(MAX_POOL_SIZE);

        dataSource = hikariDataSource;
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

}
