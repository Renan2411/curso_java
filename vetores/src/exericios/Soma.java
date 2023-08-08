package exericios;

import java.util.Scanner;

public class Soma {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n;
        double soma = 0;
        double[] numerosDigitados;


        System.out.print("Quantos números serão digitados: ");
        n = sc.nextInt();

        numerosDigitados = new double[n];

        for (int i = 0; i < numerosDigitados.length; i++) {
            System.out.print("Digite um número: ");
            numerosDigitados[i] = sc.nextDouble();

            soma += numerosDigitados[i];
        }

        System.out.print("Valores = ");

        for(double numeroDigitado : numerosDigitados){
            System.out.printf(numeroDigitado + "\t");
        }

        System.out.printf("\nSOMA = %.2f\nMEDIA = %.2f", soma, (soma/numerosDigitados.length));
    }
}
