package org.example;

import org.example.db.DB;
import org.example.db.DbException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExemploRecuperarDados {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM department");
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
            DB.closeConnection();
        }
    }
}
