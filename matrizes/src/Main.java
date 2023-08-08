import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n, negativeNumbers = 0;
        int[][] matriz;

        n = sc.nextInt();
        matriz = new int[n][n];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i][i] + " ");
        }

        for (int[] ints : matriz) {
            for (int j = 0; j < matriz.length; j++) {
                if (ints[j] < 0) {
                    negativeNumbers++;
                }
            }
        }

        System.out.println();
        System.out.println("Números Negativos = " + negativeNumbers);

    }
}