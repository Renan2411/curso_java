package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SellerDaoJDBC implements SellerDao {

    private static final String SQL_FIND_BY_ID = "SELECT seller.*, department.Name as dpName FROM seller " +
            "INNER JOIN department " +
            "ON seller.DepartmentId = department.Id " +
            "WHERE seller.Id = (?) ";

    private static final String SQL_FIND_BY_DEPARTMENT_ID = "SELECT seller.*, department.Name as dpName FROM seller " +
            "INNER JOIN department " +
            "ON seller.DepartmentId = department.Id " +
            "WHERE seller.DepartmentId = (?) " +
            "ORDER BY Name";

    private static final String SQL_FIND_ALL = "SELECT seller.*, department.Name as dpName FROM seller " +
            "INNER JOIN department " +
            "ON seller.DepartmentId = department.id " +
            "ORDER BY Name;";

    private static final String SQL_INSERT = "INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) " +
            "VALUES (?,?,?,?,?)";

    private static final String SQL_UPDATE = "UPDATE seller " +
            "SET Name = (?), " +
            "Email = (?)," +
            "BirthDate = (?)," +
            "BaseSalary = (?)," +
            "DepartmentId = (?) " +
            "WHERE id = (?)";

    private static final String SQL_DELETE = "DELETE FROM Seller WHERE id = (?)";

    private final Connection connection;

    public SellerDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Integer insert(Seller seller) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Integer sellerId = null;

        try {
            preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, seller.getName());
            preparedStatement.setString(2, seller.getEmail());
            preparedStatement.setDate(3, new java.sql.Date(seller.getBirthDate().getTime()));
            preparedStatement.setDouble(4, seller.getBaseSalary());
            preparedStatement.setInt(5, seller.getDepartment().getId());

            int rowAffected = preparedStatement.executeUpdate();

            if (rowAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();

                if (resultSet.next()) {
                    sellerId = resultSet.getInt(1);
                    System.out.println("Seller com id " + sellerId + " inserido com sucesso.");
                }
            }

            return sellerId;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DbException("Error to insert new Seller.");
        } finally {
            closeObjects(preparedStatement, resultSet);
        }
    }

    @Override
    public void update(Seller seller) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(SQL_UPDATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, seller.getName());
            preparedStatement.setString(2, seller.getEmail());
            preparedStatement.setDate(3, new java.sql.Date(seller.getBirthDate().getTime()));
            preparedStatement.setDouble(4, seller.getBaseSalary());
            preparedStatement.setInt(5, seller.getDepartment().getId());
            preparedStatement.setInt(6, seller.getId());

            int rowAffected = preparedStatement.executeUpdate();

            if (rowAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();

                if (resultSet.next()) {
                    System.out.println("Seller com id " + seller.getId() + " atualizado com sucesso.");
                }
            } else {
                throw new DbException("Erro inesperado ao atualizar seller.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DbException("Error to insert new Seller.");
        } finally {
            closeObjects(preparedStatement, resultSet);
        }
    }

    @Override
    public void deleteById(Integer sellerId) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, sellerId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DbException("Error to deller Seller.");
        } finally {
            closeObjects(preparedStatement, resultSet);
        }

    }

    @Override
    public Seller findById(Integer sellerId) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Seller seller = null;

        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID);
            preparedStatement.setInt(1, sellerId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Department department = criarInstanciaDepartment(resultSet);
                seller = criarInstanciaSeller(resultSet, department);
            }

            return seller;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DbException("Error to find SELLER by id");
        } finally {
            closeObjects(preparedStatement, resultSet);
        }
    }

    @Override
    public List<Seller> findByDepartmentId(Integer departmentId) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_DEPARTMENT_ID);
            preparedStatement.setInt(1, departmentId);
            resultSet = preparedStatement.executeQuery();

            return montarListaSellers(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DbException("Error to find Sellers by department id: " + e.getMessage());
        } finally {
            closeObjects(preparedStatement, resultSet);
        }
    }

    @Override
    public List<Seller> findAll() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_ALL);
            resultSet = preparedStatement.executeQuery();

            return montarListaSellers(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DbException("Error to find Sellers: " + e.getMessage());
        } finally {
            closeObjects(preparedStatement, resultSet);
        }
    }

    private static void closeObjects(PreparedStatement preparedStatement, ResultSet resultSet) {
        DB.closeStatement(preparedStatement);
        DB.closeResultSet(resultSet);
    }

    private static Department criarInstanciaDepartment(ResultSet resultSet) throws SQLException {
        return new Department(resultSet.getInt("DepartmentId"), resultSet.getString("dpName"));
    }

    private static Seller criarInstanciaSeller(ResultSet resultSet, Department department) throws SQLException {
        return new Seller(resultSet.getInt("Id"),
                resultSet.getString("Name"),
                resultSet.getString("Email"),
                resultSet.getDate("BirthDate"),
                resultSet.getDouble("BaseSalary"),
                department);
    }

    private List<Seller> montarListaSellers(ResultSet resultSet) throws SQLException {
        List<Seller> sellers = new ArrayList<>();

        while (resultSet.next()) {
            Department department = criarInstanciaDepartment(resultSet);
            sellers.add(criarInstanciaSeller(resultSet, department));
        }

        return sellers;
    }

}
