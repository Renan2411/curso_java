import entities.Employee;
import entities.OutSourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Employee> listEmployees = new ArrayList<>();

        int n = 0;

        System.out.print("Enter the number of employees: ");
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            Employee employee;

            System.out.println("Employee #" + i + " data:");

            System.out.print("Outsourced (y/n): ");
            char outsourced = sc.next().charAt(0);

            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Hours: ");
            int hours = sc.nextInt();

            System.out.print("Value per Hour: ");
            double valuePerHour = sc.nextDouble();

            if(outsourced == 'y'){
                System.out.print("Additional cahnge: ");
                double additionalCharge = sc.nextDouble();

                employee = new OutSourcedEmployee(name, hours, valuePerHour, additionalCharge);
            }else{
                employee = new Employee(name, hours, valuePerHour);
            }

            listEmployees.add(employee);

        }

        System.out.println("");
        System.out.println("Payments:");

        for(Employee employee : listEmployees ){
            System.out.println(employee.getName() + " - $ " + employee.payment());
        }

    }
}