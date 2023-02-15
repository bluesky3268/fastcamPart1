package org.example.ch5;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

    private static final String url = "jdbc:h2:mem://localhost/~/jdbc-practice;MODE=MySQL;DB_CLOSE_DELAY=1";
    private static final String driverClassName = "org.h2.Driver";
    private static final String id = "sa";
    private static final String password = "";

    public static DataSource getDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();

        hikariDataSource.setDriverClassName(driverClassName);
        hikariDataSource.setJdbcUrl(url);
        hikariDataSource.setUsername(id);
        hikariDataSource.setPassword(password);

        return hikariDataSource;
    }

    public static Connection getConnection() {
        try{
            Class.forName(driverClassName);
            return DriverManager.getConnection(url, id, password);
        } catch (Exception e) {
            return null;
        }

    }

}
