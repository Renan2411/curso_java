import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        File file = new File("/home/az/Área de Trabalho/curso_java/modulo-15/tratamento-excecoes/src/in.txt");
        Scanner sc = null;

        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file: " + e.getMessage());
        } finally {
            System.out.println("Executado");
            if (sc != null) {
                sc.close();
            }
        }

//        method1();
        System.out.println("Fim do programa");
    }

    public static void method1() {
        System.out.println("**********METHOD 1 Start*********");
        method2();
        System.out.println("**********METHOD 1 END*********");
    }

    public static void method2() {
        System.out.println("*********METHOD 2 START******");

        Scanner sc = new Scanner(System.in);
        try {
            String[] vect = sc.nextLine().split(" ");

            int position = sc.nextInt();

            System.out.println(vect[position]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Posição Inválida");
            e.printStackTrace();
            sc.next();
        } catch (InputMismatchException e) {
            System.out.println("Valor inválido");
        }

        System.out.println("*********METHOD 2 END******");

    }
}