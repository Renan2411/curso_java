package org.example;

import org.example.db.DB;
import org.example.db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ExemploAtualizarDados {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = DB.getConnection();
            pst = conn.prepareStatement("UPDATE seller SET BaseSalary = (?) WHERE DepartmentId = (?)", Statement.RETURN_GENERATED_KEYS);
            pst.setDouble(1, 12000.00);
            pst.setInt(2, 1);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println(rowsAffected + " linhas afetadas!");
            } else {
                System.out.println("Nenhuma linha alterada.");
            }


        } catch (Exception e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(pst);
            DB.closeConnection();
        }
    }
}