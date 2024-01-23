import entites.Circle;
import entites.Rectangle;
import entites.Shape;
import enuns.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of shapes: ");
        List<Shape> shapes = new ArrayList<>();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Shape #" + (i + 1) + " data:");

            System.out.print("Switch (r/c): ");
            char shape = sc.next().charAt(0);

            sc.nextLine();

            System.out.print("Color (BLACK, RED, BLUE): ");
            Color color = Color.valueOf(sc.nextLine());

            if (shape == 'r') {

                System.out.print("Width: ");
                double width = sc.nextDouble();

                System.out.print("Height");
                double height = sc.nextDouble();

                shapes.add(new Rectangle(color, width, height));
            } else {
                System.out.print("Radius: ");
                double radius = sc.nextDouble();

                shapes.add(new Circle(color, radius));
            }
        }

        System.out.println("Shape Areas: ");
        for (Shape s : shapes) {
            System.out.printf("%.2f\n", s.area());
        }

    }
}