package exericios;

import java.util.Scanner;

public class Negativos {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);


        System.out.print("Quantos numeros serão digitados: ");
        int n = sc.nextInt();

        int[] numerosDigitados = new int[n];

        for(int i = 0; i < numerosDigitados.length; i++){
            System.out.print("Digite um número: ");
            numerosDigitados[i] = sc.nextInt();
        }

        System.out.println("NUMEROS NEGATIOS: ");

        for (int numerosDigitado : numerosDigitados) {
            if (numerosDigitado < 0) {
                System.out.printf(numerosDigitado + "\n");
            }
        }

    }
}
