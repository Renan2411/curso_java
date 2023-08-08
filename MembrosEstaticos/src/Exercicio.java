import util.CurrencyConverter;

import java.util.Scanner;

public class Exercicio {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("What is the dollar price? ");
        double dollar = sc.nextDouble();

        System.out.print("How many dollar will be bought? ");
        double amoutDollar = sc.nextDouble();

        System.out.printf("Amount to be paid in reais = %.2f", CurrencyConverter.dolarConverter(amoutDollar, dollar));
    }

}
