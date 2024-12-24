import services.GenericPrintService;
import services.PrintService;

import java.util.Scanner;

public class AulaGenerics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PrintService ps = new PrintService();
        GenericPrintService<Integer> gps = new GenericPrintService<>();
        GenericPrintService<String> psString = new GenericPrintService<>();

        System.out.println("Quantos valores");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            String string = sc.next();
            gps.addValue(value);
            ps.addValue(value);
            psString.addValue(string);
        }

        gps.print();
        psString.print();
        ps.print();
        System.out.println("First: " + gps.first());
        System.out.println("First: " + psString.first());
        System.out.println("First: " + ps.first());
        sc.close();
    }
}