import entities.Product;
import util.MyComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> produtos = new ArrayList<>();

        produtos.add(new Product("TV", 900.00));
        produtos.add(new Product("Notebook", 1200.00));
        produtos.add(new Product("Tablet", 450.00));

        //Precisa implementar o Comparable para usar;
//        Collections.sort(produtos);

        //Recebe um Comparable<T> que é uma interface funcional, que possuí apenas um método
        produtos.sort(new MyComparator());

//        Modo por classe anônima
        Comparator<Product> comparatorClasseAnonima = new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName()
                        .toUpperCase()
                        .compareTo(p2.getName().toUpperCase());
            }
        };

        //Por expressão lambda, que é uma função anônima, aqui o compilador faz uma inferência de tipos
        Comparator<Product> comparator = (p1, p2) -> p1.getName()
                .toUpperCase()
                .compareTo(p2.getName().toUpperCase());

        produtos.sort(comparator);

        for (Product produto : produtos) {
            System.out.println(produto);
        }

    }
}