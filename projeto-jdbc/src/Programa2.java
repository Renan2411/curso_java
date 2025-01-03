import model.dao.DepartmentDao;
import model.dao.factory.DaoFactory;
import model.entities.Department;

import java.util.List;

public class Programa2 {

    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: department findById ===");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println("=== TEST 2: department findAll ===");
        List<Department> departments = departmentDao.findAll();
        departments.forEach(System.out::println);

        System.out.println("=== TEST 3: department update ===");
        Department departmentAhSerAtualizado = new Department(1, "Computadores");
        departmentDao.update(departmentAhSerAtualizado);
        department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println("=== TEST 4: department insert ===");
        Department departmentAhSerInserido = new Department( "Inserção TESTE");
        departmentDao.insert(departmentAhSerInserido);
        departments = departmentDao.findAll();
        departments.forEach(System.out::println);

        System.out.println("=== TEST 5: department delete ===");
        departmentDao.deleteById(3);
        departments = departmentDao.findAll();
        departments.forEach(System.out::println);
    }

}
