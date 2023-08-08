import entities.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Student estudante = new Student();

        estudante.name = sc.nextLine();
        estudante.firstGrade = sc.nextDouble();
        estudante.secondGrade = sc.nextDouble();
        estudante.thirdGrade = sc.nextDouble();

        System.out.println(estudante.toSring());

    }
}