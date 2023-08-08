package exericios;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Exercicio {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        List<Employee> listaEmpregados = new ArrayList<>();

        System.out.print("How many employes will be registered: ");
        int n = sc.nextInt();

        System.out.println();

        for(int i = 0;  i < n; i++){
            System.out.println("Employee #" + (i + 1));

            System.out.print("Id: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            listaEmpregados.add(new Employee(id, name, salary));
            System.out.println();
        }

        System.out.print("Enter the employee id that will have salary increase: ");
        int employeeId = sc.nextInt();

        System.out.println();

        Employee empregado = listaEmpregados.stream().filter(employee -> employee.getId() == employeeId).findFirst().orElse(null);

        if(Objects.isNull(empregado)){
            System.out.println("This id does not exist!");
        }else{
            System.out.print("Enter the pencentage: ");
            empregado.increaseSalary(sc.nextDouble());
        }

        System.out.println("List of employees");

        for(Employee employee : listaEmpregados){
            System.out.println(employee);
        }


    }
}
