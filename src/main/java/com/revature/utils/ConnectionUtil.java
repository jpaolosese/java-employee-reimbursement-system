package com.revature.utils;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    public static Connection getConnection() throws SQLException {
        // 1. Register Postgres driver with JDBC
        Driver postgresDriver = new Driver();
        DriverManager.registerDriver(postgresDriver);

        // 2. Create connection obj
        // url: connection string, jdbc:postgresql://<host>:5432/<db name>
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://database-1.cxro3z3sopmx.us-west-2.rds.amazonaws.com:5432/postgres",
                "postgres", "JPS-revature-1995"
        );
        return con;
    }
}
