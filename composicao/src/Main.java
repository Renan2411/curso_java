import entities.Departament;
import entities.HourContract;
import entities.Worker;
import enuns.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        Departament departament;
        Worker worker;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfMesAno = new SimpleDateFormat("MM/yyyy");

        System.out.print("Enter department's name: ");
        departament = new Departament(sc.nextLine());

        System.out.println("Enter Worker Data: ");

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Level: ");
        String level = sc.nextLine();

        System.out.print("Base Salary: ");
        double baseSalary = sc.nextDouble();

        worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, departament);

        System.out.print("How many contracts to this worker: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.printf("Enter contract #%d data: \n", i + 1);

            System.out.print("Date (DD/MM/YYYY): ");
            Date date = sdf.parse(sc.next());

            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            System.out.print("Duration (hours): ");
            int duration = sc.nextInt();

            worker.addContract(new HourContract(date, valuePerHour, duration));
        }

        System.out.print("Enter month an year to calculate income (MM/YYYY): ");
        Date date = sdfMesAno.parse(sc.next());

        System.out.println(worker);
        System.out.println("Income for " + sdfMesAno.format(date) + ": " + worker.income(date.getYear(), date.getMonth()));

    }
}