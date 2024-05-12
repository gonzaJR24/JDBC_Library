package org.example.DBEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBEntity {
    public static Connection conn;
    Statement statement = null;

    public DBEntity() {

    }

    public void conectar() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pubs?" +
                    "user=root");
            String data = conn.getMetaData().getDatabaseProductName();
            System.out.println(data);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getData(String querySentence) {
        ResultSet res = null;
        try {
            res = conn.createStatement().executeQuery(querySentence);
            return res;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean execSQL(String querySentence) {
        try {
            statement = conn.createStatement(); // Instantiate the 'statement' object
            statement.execute(querySentence);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
}



