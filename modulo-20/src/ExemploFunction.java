import entities.Product;
import util.ProductConsumer;
import util.ProductFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExemploFunction {

    public static void main(String[] args) {
        List<Product> produtos = new ArrayList<>();

        produtos.add(new Product("TV", 900.00));
        produtos.add(new Product("Notebook", 1200.00));
        produtos.add(new Product("Tablet", 45.00));
        produtos.add(new Product("Hd Case", 10.00));

        List<String> nomes;

        //Implementação de interface
        nomes = produtos.stream()
                .map(new ProductFunction())
                .collect(Collectors.toList());

        //Method reference static
        nomes = produtos.stream()
                .map(Product::staticUpperCaseName)
                .collect(Collectors.toList());

        //Method reference non static
        nomes = produtos.stream()
                .map(Product::nonStaticUpperCaseName)
                .collect(Collectors.toList());

        //Expressão lambda declarada
        Function<Product, String> function = p -> p.getName().toUpperCase();
        nomes = produtos.stream()
                .map(function)
                .collect(Collectors.toList());

        //Expressão lambda inline
        nomes = produtos.stream()
                .map(p -> p.getName().toUpperCase())
                .collect(Collectors.toList());

        nomes.forEach(System.out::println);

    }

}
