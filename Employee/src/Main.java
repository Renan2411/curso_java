import entities.Employee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Employee funcionario = new Employee();

        System.out.print("Name: ");
        funcionario.name = sc.nextLine();

        System.out.print("Gross Salary: ");
        funcionario.grossSalary = sc.nextDouble();

        System.out.print("Tax: ");
        funcionario.tax = sc.nextDouble();

        System.out.println("Employee: " + funcionario.toString());

        System.out.print("Wich percentage to increase salary: ");
        funcionario.increaseSalary(sc.nextDouble());

        System.out.println("Updated data: " + funcionario.toString());

    }
}