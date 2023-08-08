package apllication;

import entities.Triangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Triangle x, y;

        x = new Triangle();
        y = new Triangle();


        System.out.print("Digite os lados do triângulo X: ");
        x.a = sc.nextDouble();
        x.b = sc.nextDouble();
        x.c = sc.nextDouble();

        System.out.print("Digite os lados do triângulo Y: ");
        y.a = sc.nextDouble();
        y.b = sc.nextDouble();
        y.c = sc.nextDouble();

        double areaX = x.calcularArea();
        double areaY = y.calcularArea();

        System.out.printf("Triangle X area: %.4f\n", areaX);
        System.out.printf("Triangle Y area: %.4f\n", areaY);
        System.out.println("Large area: " + calcularMaior(areaX, areaY));

        //Problema sem Orientação

//        double xa, xb, xc;
//        double ya, yb, yc;
//
//        System.out.print("Digite os lados do triângulo X: ");
//        xa = sc.nextDouble();
//        xb = sc.nextDouble();
//        xc = sc.nextDouble();
//
//        System.out.print("Digite os lados do triângulo Y: ");
//        ya = sc.nextDouble();
//        yb = sc.nextDouble();
//        yc = sc.nextDouble();
//
//        double perimetroX = calcularPerimetroTriangulo(xa, xb, xc);
//        double perimetroY = calcularPerimetroTriangulo(ya, yb, yc);
//
//
//        double areaX = calcularAreaTriangulo(perimetroX, xa, xb, xc);
//        double areaY = calcularAreaTriangulo(perimetroY, ya, yb, yc);
//
//        System.out.printf("Triangle X area: %.4f\n", areaX);
//        System.out.printf("Triangle Y area: %.4f\n", areaY);
//        System.out.println("Large area: " + calcularMaior(areaX, areaY));

        sc.close();
    }

    public static double calcularPerimetroTriangulo(double a, double b, double c){
        return (a + b + c)/2;
    }

    public static double calcularAreaTriangulo(double perimetro, double a, double b, double c){
        return Math.sqrt(perimetro * (perimetro - a) * (perimetro - b) * (perimetro - c));
    }

    public static String calcularMaior(double a, double b){
        if (b > a){
            return "Y";
        }

        return "X";
    }
}