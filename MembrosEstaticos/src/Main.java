import util.Calculator;

import java.util.Scanner;

public class Main {

    public static final double PI = 3.14159;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();

        double c = Calculator.circumference(radius);

        double v = Calculator.volume(radius);

        System.out.printf("Circumference: %.2f\n", c);
        System.out.printf("Volume: %.2f\n", v);
        System.out.printf("PI: %.2f\n", Calculator.PI);

        /* Versão com métodos não estáticos
        double c = calc.circumference(radius);

        double v = calc.volume(radius);

        System.out.printf("Circumference: %.2f\n", c);
        System.out.printf("Volume: %.2f\n", v);
        System.out.printf("PI: %.2f\n", calc.PI);
         */

        /* Versão sem classes
        double c = circumference(radius);

        double v = volume(radius);

        System.out.printf("Circumference: %.2f\n", c);
        System.out.printf("Volume: %.2f\n", v);
        System.out.printf("PI: %.2f\n", PI);


         */
        sc.close();
    }

//    public static double circumference(double radius){
//        return 2 * PI * radius;
//    }
//
//    public static double volume(double radius){
//        return 4 * PI * Math.pow(radius, 3) / 3;
//    }
}