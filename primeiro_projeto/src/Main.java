import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int y = 32;
        double x = 10.35784;

        System.out.print("Hello World!!");
        System.out.println("Bom dia!!!");

        System.out.printf("%f%n", x);
        System.out.printf("%.2f%n", x); //Mascara de formatação para casas decimais
        System.out.printf("%.4f%n", x);

        System.out.println("RESULTADO = " + x + " METROS");
        System.out.printf("RESULTADO = %.2f metros%n", x);

        System.out.println(y);

        String product1 = "Computer";
        String product2 = "Office desk";
        int age = 30;
        int code = 5290;
        char gender = 'F';
        double price1 = 2100.0;
        double price2 = 650.50;
        double measure = 53.234567;

        System.out.println("Products:");
        System.out.printf("%s, wichi price is  %.2f%n%s wich price is  %.2f%n", product1, price1, product2, price2);
        System.out.printf("%nRecords: %d years old, code %d and gender: %c%n", age, code, gender);
        System.out.printf("%nMeasure with eigth decimal places: %.8f %n", measure);
        System.out.printf("Measure with three decimal places: %.3f %n", measure);

        Locale.setDefault(Locale.US);
        System.out.printf("Us Decimal point: %.8f %n", measure);

        //Entrada de dados

        Scanner sc = new Scanner(System.in);
        String palavra;
        int num;
        double numReal;
        char letra;


        System.out.print("Digite uma palavra: ");
        palavra = sc.next();
        System.out.print("Digite um numero: ");
        num = sc.nextInt();
        System.out.print("Digite um numero real: ");
        numReal = sc.nextDouble();
        System.out.print("Digite uma letra: ");
        letra = sc.next().charAt(1);



        System.out.println();
        System.out.println(palavra);
        System.out.println(num);
        System.out.println(numReal);
        System.out.println(letra);


        sc.close();
    }
}