package org.example;

import org.example.db.DB;
import org.example.db.DbException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ExemploTransacoes {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false);

            st = conn.createStatement();

            int x = 1;
            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 1000 WHERE DepartmentId = 1");

            if (x < 2) {
                throw new SQLException("Fake Error");
            }

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 2000 WHERE DepartmentId = 2");

            System.out.println("rows 1 " + rows1);
            System.out.println("rows 2 " + rows2);
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
                throw new DbException("Transactional rolled back! Caused by: " + e.getMessage());
            } catch (SQLException ex) {
                throw new DbException("Error trying to rolled back! Caused by: " + ex.getMessage());
            }
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
