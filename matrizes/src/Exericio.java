import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class Exericio {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int m, n, number;
        int[][] matriz;

        m = sc.nextInt();
        n = sc.nextInt();

        System.out.println();
        matriz = new int[m][n];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }

        number = sc.nextInt();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == number) {
                    System.out.println("Position " + i + "," + j + ":");

                    if (j - 1 >= 0) {
                        System.out.println("LEFT: " + matriz[i][j - 1]);
                    }

                    if(j + 1 < matriz[i].length){
                        System.out.println("RIGHT: " + matriz[i][j + 1]);
                    }

                    if (i - 1 >= 0) {
                        System.out.println("UP: " + matriz[i - 1][j]);
                    }

                    if (i + i < matriz.length) {
                        System.out.println("DOWN: " + matriz[i+1][j]);
                    }



                }
            }
        }

    }
}
