package com.edutech.progressive.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class DatabaseConnectionManager {

    private static final Properties PROPS = new Properties();

    static {
        try (InputStream input =
                     DatabaseConnectionManager.class
                             .getClassLoader()
                             .getResourceAsStream("application.properties")) {

            if (input == null) {
                throw new RuntimeException("application.properties not found in classpath");
            }

            PROPS.load(input);

            String driver = PROPS.getProperty("spring.datasource.driver-class-name");
            if (driver != null) {
                Class.forName(driver);
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Failed to load application.properties", e);
        }
    }

    private DatabaseConnectionManager() {}

    public static Connection getConnection() throws SQLException {

        String url = PROPS.getProperty("spring.datasource.url");
        String user = PROPS.getProperty("spring.datasource.username");
        String password = PROPS.getProperty("spring.datasource.password");

        return DriverManager.getConnection(url, user, password);
    }
}