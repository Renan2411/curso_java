package application;

import entities.Product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Product produto;

        System.out.print("Digite o nome do Produto: ");
        String name = sc.nextLine();

        System.out.print("Digite o preço: ");
        double price = sc.nextDouble();

        System.out.print("Digite a quantidade: ");
        int quantity = sc.nextInt();

        produto = new Product(name, price);

//        produto.name = "Computador"; -> Não é possível acessar
        produto.setName("Computador");

        System.out.println("Product Data: " + produto);

        System.out.print("Digite a quantidade para adição: ");
        produto.addProducts(sc.nextInt());

        System.out.println("Updated Data: " + produto);

        System.out.print("Digite a quantidade para remoção: ");
        produto.removeProducts(sc.nextInt());

        System.out.println("Updated Data: " + produto);
    }
}