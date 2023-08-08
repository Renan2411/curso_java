import entities.Product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Product[] produtos = new Product[n];
        double totalPrice = 0;

        for (int i = 0; i < produtos.length; i++) {
            sc.nextLine();

            String name = sc.nextLine();
            double price = sc.nextDouble();

            produtos[i] = new Product(name, price);
        }

        for (int i = 0; i < produtos.length; i++) {
            totalPrice += produtos[i].getPrice();
        }

        System.out.println(produtos[0].getName());
        System.out.printf("Média dos Preços: %.2f", (totalPrice / produtos.length));

        sc.close();


//        Caso básico de arrays

//        int n = sc.nextInt();
//        double[] alturas = new double[n];
//
//        for(int i = 0; i < n; i++){
//            alturas[i] = sc.nextDouble();
//        }
//
//        System.out.printf("Avarage Height = %.2f\n", ((alturas[0] + alturas[1] + alturas[2]) / n));

    }
}