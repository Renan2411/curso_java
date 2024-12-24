package org.example;

import org.example.db.DB;
import org.example.db.DbException;
import org.example.db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ExemploDeletarDados {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = DB.getConnection();
            pst = conn.prepareStatement("DELETE FROM department WHERE Id = (?)", Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, 2);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println(rowsAffected + " linhas afetadas!");
            } else {
                System.out.println("Nenhuma linha alterada.");
            }


        } catch (Exception e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeStatement(pst);
            DB.closeConnection();
        }
    }
}
