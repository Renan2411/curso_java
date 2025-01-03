package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private static final String SQL_INSERT = "INSERT INTO Department (Name) Values (?)";
    private static final String SQL_UPDATE = "UPDATE Department SET Name = (?) WHERE id = (?)";
    private static final String SQL_FIND_ALL = "SELECT * FROM Department";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM Department WHERE id = (?)";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM Department WHERE id = (?)";
    private final Connection connection;
    private final SellerDao sellerDao;

    public DepartmentDaoJDBC(Connection connection, SellerDao sellerDao) {
        this.connection = connection;
        this.sellerDao = sellerDao;
    }

    @Override
    public void insert(Department department) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, department.getName());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    System.out.println("Department com id " + resultSet.getInt(1) + " inserido com sucesso.");
                }
            }
        } catch (Exception exception) {
            throw new DbException("Error to insert new Department");
        } finally {
            closeObjects(preparedStatement, resultSet);
        }
    }

    @Override
    public void update(Department department) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(SQL_UPDATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, department.getName());
            preparedStatement.setInt(2, department.getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    System.out.println("Department com id " + resultSet.getInt(1) + " atualizado com sucesso.");
                }
            }
        } catch (Exception exception) {
            throw new DbException("Error to update Department");
        } finally {
            closeObjects(preparedStatement, resultSet);
        }
    }

    @Override
    public void deleteById(Integer departmentId) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if(!sellerDao.findByDepartmentId(departmentId).isEmpty()){
            throw new DbException("Não é possível deletar este departamento, existem sellers vinculados");
        }

        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID);
            preparedStatement.setInt(1, departmentId);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    System.out.println("Department com id " + departmentId + " deletado com sucesso.");
                }
            }
        } catch (Exception exception) {
            throw new DbException("Error to delete the Department");
        } finally {
            closeObjects(preparedStatement, resultSet);
        }
    }

    @Override
    public Department findById(Integer departmentId) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Department department = null;

        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID);
            preparedStatement.setInt(1, departmentId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                department = criarInstanciaDepartment(resultSet);
            }

            return department;
        } catch (Exception exception) {
            throw new DbException("Error to find Department by id");
        } finally {
            closeObjects(preparedStatement, resultSet);
        }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Department> departments = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                departments.add(criarInstanciaDepartment(resultSet));
            }

            return departments;
        } catch (Exception exception) {
            throw new DbException("Error to find all Departments");
        } finally {
            closeObjects(preparedStatement, resultSet);
        }
    }

    private void closeObjects(PreparedStatement preparedStatement, ResultSet resultSet) {
        DB.closeStatement(preparedStatement);
        DB.closeResultSet(resultSet);
    }

    private Department criarInstanciaDepartment(ResultSet resultSet) throws Exception {
        return new Department(resultSet.getInt("Id"), resultSet.getString("Name"));
    }

}
