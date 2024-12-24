package org.example.db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.Properties;

public class DB {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (Objects.isNull(connection)) {
            openConnection();
        }

        return connection;
    }

    private static void openConnection() {
        try {
            Properties properties = loadProperties();
            String url = properties.getProperty("dburl");
            connection = DriverManager.getConnection(url, properties);
        } catch (Exception e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeConnection() {
        if (Objects.nonNull(connection)) {
            try {
                connection.close();
            } catch (Exception e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs); //Faz a leitura do arquivo .properties
            return props;
        } catch (Exception e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeStatement(Statement statement){
       if(Objects.nonNull(statement)){
           try {
               statement.close();
           } catch (Exception e) {
               throw new DbException(e.getMessage());
           }
       }
    }

    public static void closeResultSet(ResultSet resultSet){
        if(Objects.nonNull(resultSet)){
            try {
                resultSet.close();
            } catch (Exception e) {
                throw new DbException(e.getMessage());
            }
        }
    }

}
