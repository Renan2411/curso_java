package org.example;

import org.example.db.DB;
import org.example.db.DbException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class ExemploInserirDados {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pst = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            conn = DB.getConnection();
            pst = conn.prepareStatement(
                    "INSERT INTO seller"
                            + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
                            + "VALUES"
                            + "(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            pst.setString(1, "Renan");
            pst.setString(2, "renan@gmail.com");
            pst.setDate(3, new Date(sdf.parse("24/11/2002").getTime()));
            pst.setDouble(4, 7000.00);
            pst.setInt(5, 1);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println(rowsAffected + " linhas afetadas!");

                ResultSet rs = pst.getGeneratedKeys();

                while (rs.next()) {
                    System.out.println("ID do novo Vendendor: " + rs.getInt(1));
                }

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
